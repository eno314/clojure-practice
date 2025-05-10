(ns clojure-practice.paiza.forest-contest-019.count-abc
  (:require
   [clojure-practice.paiza.libs :refer [readlines split-line-by-space]]))

(defn- print-count-abc [frequencies-result]
  (println (get frequencies-result "A" 0))
  (println (get frequencies-result "B" 0))
  (println (get frequencies-result "C" 0)))

(defn main []
  (-> (readlines 2)
      (second)
      (split-line-by-space)
      (frequencies)
      (print-count-abc)))
