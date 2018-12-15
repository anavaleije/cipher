(ns cipher.vigenere-test
  (:require [cipher.vigenere :as vigenere]
            [midje.sweet :refer :all]))

(facts "encrypting letters with letters"
  (tabular
    (vigenere/encrypt-letter ?letter ?key) => ?encrypted
    ?letter ?key ?encrypted
    \a \b \b
    \w \c \y
    \z \z \y
    \u \i \c))

(facts "on vigenere encrypt"
  (tabular
    (vigenere/encrypt ?s ?k) => ?e
    ?s ?k ?e
    "Welcome to Clojure Bridge!" "cipher" "ymajsdgbdjpflcglfiklvl"))

(facts "decrypting letters with letters"
  (tabular
    (vigenere/decrypt-letter ?letter ?key) => ?decrypted
    ?letter ?key ?decrypted
    \b \b \a
    \y \c \w
    \y \z \z
    \c \i \u))

(facts "on vigenere encrypt"
  (tabular
    (vigenere/decrypt ?e ?k) => ?s
    ?e ?k ?s
    "ymajsdgbdjpflcglfiklvl" "cipher" "welcometoclojurebridge"))
