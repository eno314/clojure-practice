(ns clojure-practice.paiza.b-rank-new-level-up-problems.board
  (:require [clojure-practice.paiza.libs :refer [readlines]]))

(defn line-to-board-row [line]
  (vec (map #(= % \#) (seq line))))

(defn read-input-borad [h]
  (vec (map #(line-to-board-row %) (readlines h))))

(defn update-borad [borad x y]
  (let [borad-x-y (get-in borad [x y])]
    (assoc-in borad [x y] (not borad-x-y))))

(defn board-row-to-line [row]
  (apply str (vec (map #(if % \# \.) row))))