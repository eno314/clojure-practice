(ns clojure-practice.paiza.prime-number-primer.paiza-conjecture
  (:require
   [clojure.string :as str])
  (:import
   [java.util BitSet]))

(def square-number-limit 100000000)

(defn- eratosthenes-sieve-bitset
  [n]
  (let [size (inc n)
        sieve-bs (BitSet. size)
        limit (long (Math/sqrt n))]
    ;; initially set all odd bits to true
    (loop [i 3]
      (when (<= i size)
        (.set sieve-bs i)
        (recur (+ i 2))))
    ;; do sieve
    (doseq [i (range 3 (inc limit))]
      (when (.get sieve-bs i)
        (doseq [multiple (range (* i 2) (inc n) i)]
          (.clear sieve-bs multiple))))
    sieve-bs))

(defn- has-prime-pair?
  [n sieve-bs]
  (if (even? n)
    ;; even number n always has a prime pair because of goldbach conjecture
    true
    ;; odd square: only possible as 2 + (n-2)
    (let [idx (- n 2)]
      (and (<= 0 idx)
           (< idx (.length  sieve-bs))
           (.get sieve-bs idx)))))

(defn- find-square-numbers-has-prime-pair
  [sieve-bs]
  (let [max-k (long (Math/floor (Math/sqrt square-number-limit)))]
    (->> (range 2 (inc max-k))
         (map (fn [k] (* k k)))
         (filter #(not (has-prime-pair? % sieve-bs))))))

(defn- create-output-string
  [numbers]
  (if (empty? numbers)
    "paiza's conjecture is correct.\n"
    (str/join "\n" numbers)))

(defn main
  []
  (->> (eratosthenes-sieve-bitset square-number-limit)
       (find-square-numbers-has-prime-pair)
       ;(create-output-string)
       (count)
       (println)))
