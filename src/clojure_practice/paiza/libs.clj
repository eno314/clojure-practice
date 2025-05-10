(ns clojure-practice.paiza.libs
  (:require [clojure.string :as string]))

(defn readlines [line-lenght]
  (take line-lenght (repeatedly read-line)))

(defn read-int-value-line []
  (Long/parseLong (read-line)))

(defn split-line-by-space [line]
  (string/split line #" "))

(defn split-line-by-comma [line]
  (string/split line #","))

(defn readlines-splitted-by-space [line-lenght]
  (mapv split-line-by-space (readlines line-lenght)))

(defn read-int-values-line []
  (mapv #(Long/parseLong %) (split-line-by-space (read-line))))

(defn read-int-values-lines [line-lenght]
  (take line-lenght (repeatedly read-int-values-line)))

(defn read-line-splitted-by-space []
  (split-line-by-space (read-line)))
