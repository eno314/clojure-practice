(ns clojure-practice.paiza.prime-number-primer.prime-factorization)

(defn- get-factors
  [n]
  (loop [num n
         divisor 2
         factors []]
    (cond
      ;; finished factorization
      (> divisor (Math/sqrt num))
      (if (> num 1)
        (conj factors num)
        factors)
      ;; found a factor
      (zero? (mod num divisor))
      (recur (/ num divisor) divisor (conj factors divisor))
      ;; try next divisor
      :else
      (recur num (inc divisor) factors))))

(defn- print-results
  [factors]
  (doseq [factor factors]
    (println factor)))

(defn main
  []
  (->> (Long/parseLong (read-line))
       (get-factors)
       (print-results)))
