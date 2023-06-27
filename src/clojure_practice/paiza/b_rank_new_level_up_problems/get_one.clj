(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-one
  (:require [clojure-practice.paiza.libs :refer [read-int-values-line
                                                 readlines]]))

(defn line-to-board-row [line]
  (map #(= % \#) (seq line)))

(defn read-input-borad []
  (let [[x] (read-int-values-line)]
    (map #(line-to-board-row %) (readlines x))))

(defn update-borad [borad x y]
  (let [borad-x-y (get-in borad [x y])]
    (assoc-in borad [x y] (not borad-x-y))))

(defn board-row-to-line [row]
  (apply str (map #(if % \# \.) row)))

(defn main []
  (let [borad (read-input-borad)
        [x y] (read-int-values-line)
        new-borad (update-borad borad x y)]
    (doseq [line new-borad]
      (println (board-row-to-line line)))))