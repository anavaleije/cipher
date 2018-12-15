(ns cipher.vigenere
  (:require [cipher.utils :as utils]))

(defn encrypt-letter [letter key]
  (->> (mapv utils/to-int [letter key])
       (apply +)
       (#(mod % 26))
       (utils/to-char)))

(defn encrypt [s k]
  (->> (utils/get-letters s)
       (#(mapv encrypt-letter % (cycle k)))
       (apply str)))

(defn decrypt-letter [letter key]
  (->> (mapv utils/to-int [letter key])
       (apply -)
       (#(mod % 26))
       (utils/to-char)))

(defn decrypt [e k]
  (->> (mapv decrypt-letter e (cycle k))
       (apply str)))

(defn get-nth-frequencies [sentence length]
  (-> (take-nth length sentence)))
