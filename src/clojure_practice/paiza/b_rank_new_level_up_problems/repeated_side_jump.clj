(ns clojure-practice.paiza.b-rank-new-level-up-problems.repeated-side-jump)

(defn count-left-jump [k]
  (int (/ (+ k 1) 4)))

(defn is-just-left-point? [k]
  (zero? (mod (+ k 1) 4)))

(defn count-pass-count-between-left-and-center [k]
  (let [count (* (count-left-jump k) 2)]
    (if (is-just-left-point? k) (- count 1) count)))

; (main)
