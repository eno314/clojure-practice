(ns clojure-practice.paiza.forest-contest-001.player-number
  (:require [clojure-practice.paiza.libs :refer [read-int-value-line
                                                 readlines-splitted-by-space]]))

(defn read-input-players []
  (map #(vector (Integer/parseInt (first %)) (second %))
       (readlines-splitted-by-space (read-int-value-line))))

(defn sort-player [input-players]
  (sort-by first input-players))

(defn print-player [player]
  (println (format "%d %s" (first player) (second player))))

(defn main []
  (doseq [player (sort-player (read-input-players))]
    (print-player player)))
