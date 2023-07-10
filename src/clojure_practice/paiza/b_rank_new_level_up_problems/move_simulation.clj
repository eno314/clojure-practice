(ns clojure-practice.paiza.b-rank-new-level-up-problems.move-simulation
  (:require [clojure-practice.paiza.libs :refer [read-int-value-line
                                                 read-int-values-lines]]))

(defn main []
  (let [n (read-int-value-line)
        time_points (read-int-values-lines n)]
    (doseq [[time x y] time_points]
      (println (str time " " x " " y)))))

(main)
