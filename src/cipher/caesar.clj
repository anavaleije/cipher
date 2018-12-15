(ns cipher.caesar
  (:require [cipher.utils :as utils]))

(defn caesar-encrypt
  "encrypting a sentence w with a key k using Caesar cipher"
  [w k]
  (->> (utils/get-letters w)
       (mapv #(utils/shift % k))
       (apply str)))

(defn caesar-decrypt
  "decrypting a cipher with a key k using Caesar cipher"
  [cipher k]
  (apply str (mapv #(utils/shift % (- k)) cipher)))

(defn letters-difference [l1 l2]
  (->> (mapv utils/to-int [l1 l2])
       (apply -)
       (#(mod % 26))))

(def encr1 "radyjgtxhpsncpbxrvtctgpaejgedhtegdvgpbbxcvapcvjpvtrdbqxcxcv
iwtpeegdprwpqxaxinpcsxcitgprixktstktadebtciduphrgxeixcvapcvjp
vtlxiwpctuuxrxtcipcsgdqjhixcugphigjrijgtudgbjaixiwgtpstsegdvg
pbbxcvo")

(def k (letters-difference \p \a))

(caesar-decrypt encr1 k)
