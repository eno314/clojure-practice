(ns clojure-practice.number-place.in-out-converter
  (:require
   [clojure.string :as str]))

(defn- get-input-file-path [args]
  (if (empty? args)
    (throw (Exception. "Please provide a file path as an argument"))
    (first args)))

(defn- get-input-file-content [filepath]
  (let [file (java.io.File. filepath)]
    (cond
      (not (.exists file)) (throw (Exception. "File does not exist"))
      (not (.isFile file)) (throw (Exception. "Path is not a file"))
      :else (slurp filepath))))

(defn- board-line-to-data [board-line]
  (if (not (= (count board-line) 9))
    (throw (Exception. "Each line must be 9 characters"))
    (mapv
     (fn [c]
       (cond
         (= c \.) nil
         (contains? #{\1 \2 \3 \4 \5 \6 \7 \8 \9} c) (Character/getNumericValue c)
         :else (throw (Exception. "Each character must be a digit from 1 to 9 or ."))))
     board-line)))

(defn- board-str-to-data [board-str]
  (let [lines (str/split-lines board-str)]
    (if (< (count lines) 9)
      (throw (Exception. "Input must be 9 lines"))
      (mapv board-line-to-data lines))))

(defn input-args-to-board-data [args]
  (-> (get-input-file-path args)
      (get-input-file-content)
      (board-str-to-data)))

(defn board-data-to-output-str [board-data]
  (if (nil? board-data)
    (throw (Exception. "Invalid number place pattern"))
    (str/join "\n" (map #(str/join "" %) board-data))))
