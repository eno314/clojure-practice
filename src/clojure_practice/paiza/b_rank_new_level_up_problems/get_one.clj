(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-one
  (:require [clojure-practice.paiza.libs :refer [read-int-values-line
                                                 readlines]]))

(defn line-to-bord [line]
  (map #(= % \#) (seq line)))

(defn read-input-borad []
  (let [[x] (read-int-values-line)]
    (map #(line-to-bord %) (readlines x))))

(defn update-borad [borad x y]
  (let [borad-x-y (get-in borad [x y])]
    (assoc-in borad [x y] (not borad-x-y))))
