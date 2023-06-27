(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-one
  (:require [clojure-practice.paiza.libs :refer [read-int-values-line
                                                 readlines]]))

(defn line-to-board-row [line]
  (vec (map #(= % \#) (seq line))))

(defn read-input-borad [h]
  (vec (map #(line-to-board-row %) (readlines h))))

(defn update-borad [borad x y]
  (let [borad-x-y (get-in borad [x y])]
    (assoc-in borad [x y] (not borad-x-y))))

(defn board-row-to-line [row]
  (apply str (vec (map #(if % \# \.) row))))

(defn main []
  (let [[h _] (read-int-values-line)
        borad (read-input-borad h)
        [x y] (read-int-values-line)
        new-borad (update-borad borad x y)]
    (doseq [line new-borad]
      (println (board-row-to-line line)))))


;(main)