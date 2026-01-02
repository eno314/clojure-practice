(ns clojure-practice.paiza.euclidean-primer.rsa-solve
  (:require
   [clojure.string :as string]))

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

(defn main
  []
  (let [[p q e e'] (map #(bigint %) (string/split (read-line) #" "))
        n (* p q)
        n' (* (dec p) (dec q))
        d (calc-d e n')
        m (mod-pow [e' d n])]
    (println (char m))))
