(ns clojure-practice.paiza.b-rank-new-level-up-problems.fuel-economy
  (:require [clojure-practice.paiza.libs :refer [read-int-value-line
                                                 read-int-values-line]]))

(defn read-input []
  (let [x (read-int-value-line)
        [starting running] (read-int-values-line)
        [total_distance] (read-int-values-line)
        stop_distances (read-int-values-line)]
    {:economy {:change_distance x
               :starting starting
               :running running}
     :total_distance total_distance
     :stop_distances stop_distances}))
