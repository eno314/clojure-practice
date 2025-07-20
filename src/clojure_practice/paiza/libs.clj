(ns clojure-practice.paiza.libs
  (:require [clojure.string :as string]))

(defn read-lines [line-length]
  (take line-length (repeatedly read-line)))

(defn read-int-value-line []
  (Long/parseLong (read-line)))

(defn split-line-by-space [line]
  (string/split line #" "))

(defn split-line-by-comma [line]
  (string/split line #","))

(defn read-lines-split-by-space [line-length]
  (mapv split-line-by-space (read-lines line-length)))

(defn read-int-values-line []
  (mapv #(Long/parseLong %) (split-line-by-space (read-line))))

(defn read-int-values-lines [line-length]
  (vec (take line-length (repeatedly read-int-values-line))))

(defn read-line-split-by-space []
  (split-line-by-space (read-line)))

(defn read-int-lines [line-length]
  (vec (take line-length (repeatedly read-int-value-line))))
