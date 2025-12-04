(ns clojure-practice.paiza.prime-number-primer.greatest-common-divisor)

(defn- input-numbers
  []
  (let [n (Long/parseLong (read-line))]
    (vec (take n (repeatedly #(Long/parseLong (read-line)))))))

(defn- factors
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

(defn- factor-intersection-list
  [numbers]
  (let [factors-list (mapv factors numbers)
        min-factors (reduce
                     #(if (or (empty? %1) (< (count %2) (count %1))) %2 %1)
                     []
                     factors-list)]
    (reduce
     (fn [acc factor]
       (if (every? #(some #{factor} %) factors-list)
         (conj acc factor)
         acc))
     []
     min-factors)))

(defn main
  []
  (->> (input-numbers)
       (factor-intersection-list)
       (reduce #(* %1 %2) 1)
       (println)))
