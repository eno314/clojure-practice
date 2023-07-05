(ns clojure-practice.paiza.b-rank-new-level-up-problems.repeated-side-jump
  (:require [clojure-practice.paiza.libs :refer [read-int-values-line]]))

(defn count-left-jump [k]
  (int (/ (+ k 1) 4)))

(defn is-just-left-point? [k]
  (zero? (mod (+ k 1) 4)))

(defn count-pass-between-left-and-center [k]
  (let [count (* (count-left-jump k) 2)]
    (if (is-just-left-point? k) (- count 1) count)))

(defn calc-extra-moved [n x k]
  (let [pass-count (count-pass-between-left-and-center k)
        pass-count-before-extend (count-pass-between-left-and-center (* n 4))]
    (* x (- pass-count pass-count-before-extend))))

(defn main []
  (let [[n x k] (read-int-values-line)]
    (println (calc-extra-moved n x k))))

; (main)
