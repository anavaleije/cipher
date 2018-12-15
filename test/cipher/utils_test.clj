(ns cipher.utils-test
  (:require [cipher.utils :as utils]
            [midje.sweet :refer :all]))

(facts "takes a lowercase letter character and returns its position in the alphabet: a = 0, b = 1, etc"
  (tabular
    (utils/to-int ?char) => ?result
    ?char ?result
    \a 0
    \b 1
    \c 2
    \d 3))

(facts "takes a position in the alphabet and returns its lowercase letter character: 0 = a, 1 = b, etc."
  (tabular
    (utils/to-char ?n) => ?result
    ?n ?result
    0 \a
    1 \b
    2 \c
    3 \d))

(facts "returns char shifted by n"
  (tabular
    (utils/shift ?char ?n) => ?result
    ?char ?n ?result
    \a 3 \d
    \b 20 \v
    \z 3 \c))

(facts "returns only letters from sentence, lowercased"
  (tabular
    (utils/get-letters ?s) => ?letters
    ?s ?letters
    "Hello, friend!" "hellofriend"))

(facts "counts letter occurences in a sentence"
  (tabular
    (utils/count-letters ?c ?s) => ?n
    ?c ?s ?n
    \a "aadvark" 3
    \x "aadvark" 0))

(def encr1 "radyjgtxhpsncpbxrvtctgpaejgedhtegdvgpbbxcvapcvjpvtrdbqxcxcv
iwtpeegdprwpqxaxinpcsxcitgprixktstktadebtciduphrgxeixcvapcvjp
vtlxiwpctuuxrxtcipcsgdqjhixcugphigjrijgtudgbjaixiwgtpstsegdvg
pbbxcvo")

(def encr-map-sorted '([\p 19] [\t 17] [\x 17] [\c 16] [\g 16] [\i 13] [\v 11] [\d 10] [\b 8] [\e 8] [\j 8] [\r 8] [\a 7] [\s 6] [\h 5] [\u 5] [\w 4] [\q 3] [\k 2] [\n 2] [\l 1] [\o 1] [\y 1] [\f 0] [\m 0] [\z 0]))

(fact "correctly map letter occurences in a map"
  (utils/get-letters-occurrences encr1) => encr-map-sorted)
