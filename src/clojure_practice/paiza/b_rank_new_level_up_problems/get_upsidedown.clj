(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-upsidedown
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.board :refer [board-row-to-line read-input-board update-board]]
            [clojure-practice.paiza.libs :refer [read-int-values-line]]))

(defn update-board-all-point [board x y]
  (let [new-board (update-board board x y)
        new-board (update-board new-board (dec x) y)
        new-board (update-board new-board x (dec y))
        new-board (update-board new-board (inc x) y)
        new-board (update-board new-board x (inc y))]
    new-board))

(defn main []
  (let [[h] (read-int-values-line)
        board (read-input-board h)
        [y x] (read-int-values-line)
        new-board (update-board-all-point board x y)]
    (doseq [line new-board]
      (println (board-row-to-line line)))))

;(main)
