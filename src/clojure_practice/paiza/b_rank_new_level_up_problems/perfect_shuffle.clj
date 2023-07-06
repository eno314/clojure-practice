(ns clojure-practice.paiza.b-rank-new-level-up-problems.perfect-shuffle
  (:require [clojure-practice.paiza.libs :refer [read-int-value-line]]))

(defn initail-cards-of-suit [suit]
  (vec (map #(str suit "_" %) (range 1 14))))

(defn initail-cards []
  (flatten (vec (map #(initail-cards-of-suit %) ["S" "H" "D" "C"]))))

(defn shuffle-cards [cards]
  (let [half (quot (count cards) 2)
        first-half (take half cards)
        second-half (drop half cards)]
    (vec (interleave first-half second-half))))

(defn shuffle-cards-repeatedly [cards n]
  (nth (iterate shuffle-cards cards) n))

(defn main []
  (let [n (read-int-value-line)
        cards (initail-cards)
        shuffled-cards (shuffle-cards-repeatedly cards n)]
    (doseq [card shuffled-cards]
      (println card))))

; (main)
