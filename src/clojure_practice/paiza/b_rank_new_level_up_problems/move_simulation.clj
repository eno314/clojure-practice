(ns clojure-practice.paiza.b-rank-new-level-up-problems.move-simulation
  (:require [clojure-practice.paiza.libs :refer [read-int-value-line
                                                 read-int-values-lines]]))

(defn load-data []
  (let [n (read-int-value-line)
        time-and-locs (read-int-values-lines n)]
    (vec (map (fn [[time x y]] {:time time :loc [x y]}) time-and-locs))))
