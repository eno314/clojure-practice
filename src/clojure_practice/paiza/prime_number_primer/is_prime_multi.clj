(ns clojure-practice.paiza.prime-number-primer.is-prime-multi
  (:require
   [clojure.string :as str]))

(defn- read-int-value-line []
  (Long/parseLong (read-line)))

(defn- exam-numbers
  []
  (let [line-length (read-int-value-line)]
    (vec (take line-length (repeatedly read-int-value-line)))))

(defn- update-sieve
  [sieve prime]
  (loop [multiple (* 2 prime)
         updated-sieve sieve]
    (if (> multiple (dec (count sieve)))
      updated-sieve
      (recur (+ multiple prime)
             (assoc updated-sieve multiple false)))))

(defn- eratosthenes-sieve
  [n]
  (let [init-sieve (vec (concat [false, false]
                                (vec (repeat (dec n) true))))]
    (loop [i 2
           sieve init-sieve]
      (if (> i n)
        sieve
        (if (false? (get sieve i))
          (recur (inc i) sieve)
          (recur (inc i) (update-sieve sieve i)))))))

(defn- exam-numbers-to-results
  [exam-numbers]
  (let [max-number (apply max exam-numbers)
        sieve (eratosthenes-sieve max-number)]
    (str/join "\n" (map #(if (get sieve %) "pass" "failure") exam-numbers))))

(defn main
  []
  (->> (exam-numbers)
       (exam-numbers-to-results)
       (println)))
