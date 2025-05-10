(ns clojure-practice.paiza.forest-contest-019.round-table
  (:require
   [clojure.string :as string]))

(defn main []
  (as-> (read-line) x
    (map #(Long/parseLong %) (string/split x #" "))
    (let [n (first x)
          k (second x)
          m (mod k n)]
      (if (= 0 m) n m))
    (println x)))
