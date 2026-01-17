(ns clojure-practice.paiza.euclidean-primer.rsa-solve-string
  (:require
   [clojure.string :as string]))

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

(defn- extgcd
  [[a b]]
  (if (zero? b)
    [a 1 0]
    (let [[c x y] (extgcd [b (mod a b)])]
      [c y (- x (* (quot a b) y))])))

(defn- normalize-x
  [x m]
  (-> (mod x m)
      (+ m)
      (mod m)))

(defn- calc-d
  [e n']
  (let [[g x _] (extgcd [e n'])]
    (when (not= g 1)
      (throw (ex-info "No modular inverse (gcd != 1)" {:g g :e e :n' n'})))
    (normalize-x x n')))

(defn- mod-pow
  [[a e m]]
  (loop [a' (mod a m)
         e' e
         acc 1]
    (if (zero? e')
      acc
      (recur (mod (* a' a') m)
             (quot e' 2)
             (if (odd? e')
               (mod (* acc a') m)
               acc)))))

(defn decode-to-string
  [m]
  (let [m-long (long m)]
    (->> [21 14 7 0] ;各シフト量
         (map #(bit-shift-right m-long %)) ;シフトして
         (map #(bit-and % 0x7F)) ;下位7ビットを取り出す
         (remove zero?) ;0 (文字なし) を除去
         (map char)
         (apply str))))

(defn main
  []
  (let [[n e e'] (map #(bigint %) (string/split (read-line) #" "))
        [p q] (get-factors n)
        n' (* (dec p) (dec q))
        d (calc-d e n')]
    (-> (mod-pow [e' d n])
        (decode-to-string)
        (println))))
