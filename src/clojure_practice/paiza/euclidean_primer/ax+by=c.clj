(ns clojure-practice.paiza.euclidean-primer.ax+by=c
  (:require
   [clojure.string :as string]))

(defn- resolve-xy
  [[a b c]]
  (if (= c (mod a b))
    [1 (- (quot a b))]
    [(- (quot b a)) 1]))

(defn main
  []
  (->> (map #(Long/parseLong %) (string/split (read-line) #" "))
       (resolve-xy)
       (string/join " ")
       (println)))
