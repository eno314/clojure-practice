(ns clojure-practice.paiza.forest-contest-019.visibility
  (:require
   [clojure.string :as string]))

(defn- read-hw []
  (let [values (map
                #(Long/parseLong %)
                (string/split (read-line) #" "))]
    {:h (first values)
     :w (second values)}))

(defn- read-map [hw]
  (vec (map vec (take (get hw :h) (repeatedly read-line)))))

(defn- find-a-pos [hw visibility-map]
  (first
   (for [row (range (get hw :w))
         col (range (get hw :h))
         :when (= \A (get-in visibility-map [col row]))]
     [col row])))

(defn- replace-map-recur [f-next-pos a-pos visibility-map]
  (loop [replaced visibility-map
         replaced-pos (f-next-pos a-pos)]
    (if (or (nil? replaced-pos)
            (= \T (get-in replaced replaced-pos)))
      replaced
      (recur
       (assoc-in replaced replaced-pos \V)
       (f-next-pos replaced-pos)))))

(defn- replace-upward [a-pos visibility-map]
  (replace-map-recur
   (fn [pos]
     (if (zero? (first pos))
       nil
       [(dec (first pos)) (second pos)]))
   a-pos
   visibility-map))

(defn- replace-downward [a-pos hw visibility-map]
  (replace-map-recur
   (fn [pos]
     (if (< (first pos) (dec (get hw :h)))
       [(inc (first pos)) (second pos)]
       nil))
   a-pos
   visibility-map))

(defn- replace-leftward [a-pos visibility-map]
  (replace-map-recur
   (fn [pos]
     (if (zero? (second pos))
       nil
       [(first pos) (dec (second pos))]))
   a-pos
   visibility-map))

(defn- replace-rightward [a-pos hw visibility-map]
  (replace-map-recur
   (fn [pos]
     (if (< (second pos) (dec (get hw :w)))
       [(first pos) (inc (second pos))]
       nil))
   a-pos
   visibility-map))

(defn- replace-map [hw visibility-map]
  (if-let [a-pos (find-a-pos hw visibility-map)]
    (->> (replace-upward a-pos visibility-map)
         (replace-downward a-pos hw)
         (replace-leftward a-pos)
         (replace-rightward a-pos hw))
    (throw (Exception. "Invalid map because A can not found."))))

(defn main []
  (let [hw (read-hw)]
    (->> (read-map hw)
         (replace-map hw)
         (map #(apply str %))
         (string/join "\n")
         (println))))
