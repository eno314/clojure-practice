(ns clojure-practice.paiza.euclidean-primer.lcm
  (:require
   [clojure.string :as string]))

(defn- gcd
  [[a b]]
  (loop [x a
         y b]
    (cond
      (zero? x) y
      (zero? y) x
      (< x y) (recur x (mod y x))
      :else (recur y (mod x y)))))

(defn- lcm
  [[a b]]
  (/ (* a b) (gcd [a b])))

(defn main
  []
  (->> (map #(Long/parseLong %) (string/split (read-line) #" "))
       (lcm)
       (println)))
