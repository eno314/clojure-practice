(ns clojure-practice.paiza.euclidean-primer.fast-exponentiation
  (:require
   [clojure.string :as string]))

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
  (-> (map #(Long/parseLong %) (string/split (read-line) #" "))
      (mod-pow)
      (println)))