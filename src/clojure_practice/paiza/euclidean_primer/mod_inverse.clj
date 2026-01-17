(ns clojure-practice.paiza.euclidean-primer.mod-inverse
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

(defn main
  []
  (let [[m a] (map #(Long/parseLong %) (string/split (read-line) #" "))
        [g x _] (extgcd [a m])]
    (when (not= g 1)
      (throw (ex-info "No modular inverse (gcd != 1)" {:g g :a a :m m})))
    (println (normalize-x x m))))

