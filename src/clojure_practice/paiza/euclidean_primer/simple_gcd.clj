(ns clojure-practice.paiza.euclidean-primer.simple-gcd
  (:require
   [clojure.string :as string]))

(defn gcd
  [[a b]]
  (loop [x a
         y b]
    (cond
      (zero? x) y
      (zero? y) x
      (< x y) (recur x (mod y x))
      :else (recur y (mod x y)))))

(defn main
  []
  (->> (map #(Long/parseLong %) (string/split (read-line) #" "))
       (gcd)
       (println)))
