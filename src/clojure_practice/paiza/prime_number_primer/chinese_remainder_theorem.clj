(ns clojure-practice.paiza.prime-number-primer.chinese-remainder-theorem
  (:require
   [clojure.string :as str]))

(defn- find-candidates
  [m b limit]
  (loop [i b
         candidates []]
    (if (>= i limit)
      candidates
      (recur (+ i m) (conj candidates i)))))

(defn- find-chinese-remainder-theorem
  [[m1 m2 b1 b2]]
  (let [limit (* m1 m2)
        candidates (find-candidates m1 b1 limit)]
    (filter #(= b2 (mod % m2)) candidates)))

(defn- get-result
  [result]
  (if (= 1 (count result))
    (first result)
    (throw (Exception. "Theorem is not satisfied."))))

(defn main
  []
  (->> (mapv #(Long/parseLong %)
             (str/split (str/trim (read-line)) #" "))
       (find-chinese-remainder-theorem)
       (get-result)
       (println)))
