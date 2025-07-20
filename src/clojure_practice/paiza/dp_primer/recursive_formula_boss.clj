(ns clojure-practice.paiza.dp-primer.recursive-formula-boss
  (:require
   [clojure-practice.paiza.libs :refer [read-int-lines read-int-value-line]]))

(defn- read-input []
  (-> (read-int-value-line)
      (read-int-lines)))

(defn- fibonaccis-to [n]
  (loop [idx 2
         fibs [0 1]]
    (if (> idx n)
      fibs
      (recur (inc idx)
             (conj fibs
                   (+ (nth fibs (- idx 1))
                      (nth fibs (- idx 2))))))))

(defn main []
  (let [targets (read-input)
        fibonaccis (fibonaccis-to (apply max targets))]
    (doseq [target targets]
      (println (get fibonaccis target)))))
