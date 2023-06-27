(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-one
  (:require [clojure-practice.paiza.libs :refer [read-int-values-line
                                                 readlines]]))

(defn line-to-bord [line]
  (map #(= % \#) (seq line)))

(defn read-input-borad []
  (let [[x] (read-int-values-line)]
    (map #(line-to-bord %) (readlines x))))