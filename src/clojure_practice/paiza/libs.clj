(ns clojure-practice.paiza.libs
  (:require [clojure.string :as string]))

(defn readlines [line-lenght]
  (take line-lenght (repeatedly read-line)))

(defn read-int-value-line []
  (Integer/parseInt (read-line)))

(defn split-line-by-space [line]
  (string/split line #" "))

(defn split-line-by-comma [line]
  (string/split line #","))

(defn readlines-splitted-by-space [line-lenght]
  (vec (map split-line-by-space (readlines line-lenght))))

(defn read-int-values-line []
  (vec (map #(Integer/parseInt %) (split-line-by-space (read-line)))))
