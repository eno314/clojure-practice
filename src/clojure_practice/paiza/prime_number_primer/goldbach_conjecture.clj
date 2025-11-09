(ns clojure-practice.paiza.prime-number-primer.goldbach-conjecture
  (:require
   [clojure.string :as str]))

(defn- eratosthenes-sieve
  [n]
  (let [sieve (boolean-array (inc n) true)
        limit (long (Math/sqrt n))]
    (when (>= n 0) (aset sieve 0 false))
    (when (>= n 1) (aset sieve 1 false))
    (doseq [i (range 2 (inc limit))]
      (when (aget sieve i)
        (doseq [multiple (range (* i 2) (inc n) i)]
          (aset sieve multiple false))))
    sieve))

(defn- get-bigger-prime-pair
  [pair1 pair2]
  (if (< (* (first pair1) (second pair1))
         (* (first pair2) (second pair2)))
    pair2
    pair1))


(defn- find-prime-pair
  [n sieve]
  (loop [i 2
         pair-calc-dic {}
         result [0 0]]
    (cond
      ;; finished search
      (> i n) result
      ;; i is not prime
      (false? (aget sieve i)) (recur (inc i)
                                     pair-calc-dic
                                     result)
      ;; found a prime pair : n = i + i
      (= n (* 2 i)) (recur (inc i)
                           pair-calc-dic
                           (get-bigger-prime-pair result [i i]))
      ;; found a prime pair : n = i + (n - i)
      (contains? pair-calc-dic i) (recur (inc i)
                                         pair-calc-dic
                                         (get-bigger-prime-pair result
                                                                [(get pair-calc-dic i) i]))
      ;; not found a prime pair so continue search
      :else (recur (inc i)
                   (assoc pair-calc-dic (- n i) i)
                   result))))

(defn main
  []
  (let [n (Long/parseLong (str/trim (read-line)))
        sieve (eratosthenes-sieve n)]
    (->> (find-prime-pair n sieve)
         (str/join "\n")
         (println))))
