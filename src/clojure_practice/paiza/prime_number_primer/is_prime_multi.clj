(ns clojure-practice.paiza.prime-number-primer.is-prime-multi
  (:require
   [clojure.string :as str]))

(defn- read-int-value-line []
  (Long/parseLong (read-line)))

(defn- exam-numbers
  []
  (let [line-length (read-int-value-line)]
    (vec (take line-length (repeatedly read-int-value-line)))))

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

(defn- exam-numbers-to-results
  [exam-numbers]
  (let [max-number (apply max exam-numbers)
        sieve (eratosthenes-sieve max-number)]
    (str/join "\n" (map #(if (aget sieve %) "pass" "failure") exam-numbers))))

(defn main
  []
  (->> (exam-numbers)
       (exam-numbers-to-results)
       (println)))
