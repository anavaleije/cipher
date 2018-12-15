(ns cipher.utils)

(defn to-int
  "takes a lowercase letter character and returns its position in the alphabet: a = 0, b = 1, etc."
  [c]
  (let [ascii-a (int \a)]
    (- (int c) ascii-a)))

(defn to-char
  "takes a position in the alphabet and returns its lowercase letter character: 0 = a, 1 = b, etc."
  [n]
  (let [ascii-a (int \a)]
    (-> (+ n ascii-a)
        char)))

(def alphabet (map to-char (range 26)))

(defn shift [c n]
  "shifts a lowercase letter character c by n"
  (-> (to-int c)
      (+ n)
      (mod 26)
      (to-char)))

(defn get-letters [s]
  (->> (clojure.string/lower-case s)
       (filterv #(Character/isLetter %))
       (apply str)))

(defn count-letters [c s]
  "counts letter c occurences in a sentence s"
  (-> (filterv #(= % c) s)
      (count)))

(defn get-letters-occurrences [s]
  (->> (map #(count-letters % s) alphabet)
       (zipmap alphabet)
       (sort-by second >)))
