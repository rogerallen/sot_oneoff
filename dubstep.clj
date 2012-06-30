#_(defdeps
    [[org.clojure/clojure "1.3.0"]
     [overtone "0.7.1"]])

;; example cut-n-pasted from overtone
;; https://github.com/overtone/overtone/blob/master/examples/dubstep.clj

(ns dubstep
  (:use [overtone.live]))

(println "prepare for 60 seconds of awesome.")

(demo 60
 (let [bpm 120
       notes [40 41 28 28 28 27 25 35 78]
       trig (impulse:kr (/ bpm 120))
       freq (midicps (lag (demand trig 0 (dxrand notes INF)) 0.25))
       swr (demand trig 0 (dseq [1 6 6 2 1 2 4 8 3 3] INF))
       sweep (lin-exp (lf-tri swr) -1 1 40 3000)
       wob (apply + (saw (* freq [0.99 1.01])))
       wob (lpf wob sweep)
       wob (* 0.8 (normalizer wob))
       wob (+ wob (bpf wob 1500 2))
       wob (+ wob (* 0.2 (g-verb wob 9 0.7 0.7)))

       kickenv (decay (t2a (demand (impulse:kr (/ bpm 30)) 0 (dseq [1 0 0 0 0 0 1 0 1 0 0 1 0 0 0 0] INF))) 0.7)
       kick (* (* kickenv 7) (sin-osc (+ 40 (* kickenv kickenv kickenv 200))))
       kick (clip2 kick 1)

       snare (* 3 (pink-noise [1 1]) (apply + (* (decay (impulse (/ bpm 240) 0.5) [0.4 2]) [1 0.05])))
       snare (+ snare (bpf (* 4 snare) 2000))
       snare (clip2 snare 1)]

   (clip2 (+ wob kick snare) 1)))


