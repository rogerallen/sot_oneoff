# sot

Simplest Overtone [standalone] Test -- "oneoff" variant.

## Usage

*lein1.x only*

First, install the oneoff https://github.com/mtyaka/lein-oneoff.  

    lein plugin install lein-oneoff 0.2.0

The goal is to hear a 440Hz sine wave for a few seconds after doing only this:

    lein oneoff sot.clj

And this works for me.  So does:

    lein oneoff dubstep.clj

??? for lein2? https://github.com/kumarshantanu/lein-exec

## License

Copyright © 2012 Roger Allen

Distributed under the Eclipse Public License, the same as Clojure.
