(ns clojure-practice.paiza.prime-number-primer.number-of-divisor)

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

(defn- factors-to-factor-dict
  [factors]
  (reduce (fn [acc factor]
            (update acc factor (fnil inc 0)))
          {}
          factors))

(defn- calc-number-of-divisors
  [factor-dict]
  (reduce (fn [acc [_ count-of-factor]]
            (* acc (inc count-of-factor)))
          1
          factor-dict))

(defn main
  []
  (-> (Long/parseLong (read-line))
      (get-factors)
      (factors-to-factor-dict)
      (calc-number-of-divisors)
      (println)))
