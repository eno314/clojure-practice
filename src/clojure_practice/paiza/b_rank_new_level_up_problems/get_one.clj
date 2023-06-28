(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-one
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.board :refer [board-row-to-line read-input-borad update-borad]]
            [clojure-practice.paiza.libs :refer [read-int-values-line]]))

(defn main []
  (let [[h _] (read-int-values-line)
        borad (read-input-borad h)
        [x y] (read-int-values-line)
        new-borad (update-borad borad x y)]
    (doseq [line new-borad]
      (println (board-row-to-line line)))))

;(main)