(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-one
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.board :refer [board-row-to-line read-input-board update-board]]
            [clojure-practice.paiza.libs :refer [read-int-values-line]]))

(defn main []
  (let [[h _] (read-int-values-line)
        board (read-input-board h)
        [x y] (read-int-values-line)
        new-board (update-board board x y)]
    (doseq [line new-board]
      (println (board-row-to-line line)))))

;(main)
