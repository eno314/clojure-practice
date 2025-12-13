(ns clojure-practice.paiza.euclidean-primer.extgcd
  (:require
   [clojure.string :as string]))

(defn- ectgcd
  [[a b]]
  (if (zero? b)
    [a 1 0]
    (let [[c x y] (ectgcd [b (mod a b)])]
      [c y (- x (* (quot a b) y))])))

(defn main
  []
  (->> (map #(Long/parseLong %) (string/split (read-line) #" "))
       (ectgcd)
       (rest)
       (string/join " ")
       (println)))
