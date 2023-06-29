(ns clojure-practice.paiza.b-rank-new-level-up-problems.board
  (:require [clojure-practice.paiza.libs :refer [readlines]]))

(defn line-to-board-row [line]
  (vec (map #(= % \#) (seq line))))

(defn read-input-board [h]
  (vec (map #(line-to-board-row %) (readlines h))))

(defn should-update-board [board x y]
  (and (>= x 0) (>= y 0) (< x (count (first board))) (< y (count board))))

(defn update-board [board x y]
  (if (should-update-board board x y)
    (let [board-x-y (get-in board [y x])]
      (assoc-in board [y x] (not board-x-y)))
    board))

(defn board-row-to-line [row]
  (apply str (vec (map #(if % \# \.) row))))
