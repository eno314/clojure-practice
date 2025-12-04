(ns clojure-practice.paiza.prime-number-primer.least-common-multiple
  (:require
   [clojure.string :as str]))

(defn- input-numbers
  []
  (let [n (Long/parseLong (str/trim (read-line)))]
    (vec (take n (repeatedly #(Long/parseLong (str/trim (read-line))))))))

(defn- update-factor-count
  [factor-dict factor]
  (if (contains? factor-dict factor)
    (update factor-dict factor inc)
    (assoc factor-dict factor 1)))

(defn- get-factor-dict
  [n]
  (loop [num n
         divisor 2
         factor-dict {}]
    (cond
      ;; finished factorization
      (> divisor (Math/sqrt num))
      (if (> num 1)
        (update-factor-count factor-dict num)
        factor-dict)
      ;; found a factor
      (zero? (mod num divisor))
      (recur (/ num divisor) divisor (update-factor-count factor-dict divisor))
      ;; try next divisor
      :else
      (recur num (inc divisor) factor-dict))))

(defn- factor-dict-list
  [numbers]
  (map get-factor-dict numbers))

(defn- merge-factor-dict
  [base merged-dict]
  (reduce
   (fn [acc [merged-factor merged-count]]
     (if (> merged-count (get acc merged-factor 0))
       (assoc acc merged-factor merged-count)
       acc))
   base
   merged-dict))

(defn- merge-factor-dict-list
  [factor-dict-list]
  (reduce
   (fn [acc factor-dict]
     (merge-factor-dict acc factor-dict))
   {}
   factor-dict-list))

(defn- calculate-lcm
  [factor-dict-list]
  (->> (merge-factor-dict-list factor-dict-list)
       (reduce (fn [acc [factor count]]
                 (* acc (Math/pow factor count)))
               1)
       (long)))

(defn main
  []
  (->> (input-numbers)
       (factor-dict-list)
       (calculate-lcm)
       (println)))
