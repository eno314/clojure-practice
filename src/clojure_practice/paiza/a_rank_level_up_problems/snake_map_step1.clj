(ns clojure-practice.paiza.a-rank-level-up-problems.snake-map-step1
  (:require [clojure-practice.paiza.board :refer [board-value-to-str
                                                  read-input-board]]
            [clojure-practice.paiza.libs :refer [read-int-values-line
                                                 read-int-values-lines]]))

(defn get-values-of-points [board points]
  (vec (map #(get-in board %) points)))

(defn main []
  (let [[h _ n] (read-int-values-line)
        borad (read-input-board h)
        points (read-int-values-lines n)]
    (doseq [value (get-values-of-points borad points)]
      (println (board-value-to-str value)))))
