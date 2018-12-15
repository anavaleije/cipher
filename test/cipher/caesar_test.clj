(ns cipher.caesar-test
  (:require [cipher.caesar :as caesar]
            [midje.sweet :refer :all]))

(facts "returns ceaser cipher for sentence using key k"
  (tabular
    (caesar/caesar-encrypt ?w ?k) => ?cipher
    ?w ?k ?cipher
    "apple" 20 "ujjfy"
    "lemon" 1 "mfnpo"
    "Hello, friend!" 5 "mjqqtkwnjsi"))

(facts "returns ceaser cipher for word using key k"
  (tabular
    (caesar/caesar-decrypt ?cipher ?k) => ?w
    ?cipher ?k ?w
    "ujjfy" 20 "apple"
    "mfnpo" 1 "lemon"
    "mjqqtkwnjsi" 5 "hellofriend"))


(facts "difference between two characters ascii value"
  (tabular
    (caesar/letters-difference ?l1 ?l2) => ?n
    ?l1 ?l2 ?n
    \b  \a  1
    \b  \b  0
    \t  \a  19
    \a  \b  25))
