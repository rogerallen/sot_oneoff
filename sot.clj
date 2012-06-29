#_(defdeps
    [[org.clojure/clojure "1.3.0"]
     [overtone "0.7.1"]])

(ns sot
  (:use [overtone.live]))

(defn do-sot []
  (println "testing overtone.  you should hear a 440 Hz sine wave for a few seconds, then the program should stop")
  (demo (sin-osc))
  (Thread/sleep 5000)
  (println "done")
  (System/exit 0))

(do
  (println "calling do-sot")
  (do-sot))


