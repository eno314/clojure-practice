(ns clojure-practice.paiza.euclidean-primer.mod-equal
  (:require
   [clojure.string :as string]))

(defn- mod-equal
  [[n a]]
  (let [rem (mod a n)
        start (if (zero? rem) n rem)]
    (take-while #(<= % 100000)
                (map #(+ start (* n %)) (range)))))

(defn main
  []
  (->> (map #(Long/parseLong %) (string/split (read-line) #" "))
       (mod-equal)
       (string/join "\n")
       (println)))
