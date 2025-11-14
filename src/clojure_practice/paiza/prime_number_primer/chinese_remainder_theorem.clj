(ns clojure-practice.paiza.prime-number-primer.chinese-remainder-theorem
  (:require
   [clojure.string :as str]))

(defn- find-chinese-remainder-theorem
  [[m1 m2 b1 b2]]
  (let [limit (* m1 m2)]
    (loop [i 0
           z-candidate []]
      (cond
        (= i limit) z-candidate
        (not= b1 (mod i m1)) (recur (inc i) z-candidate)
        (not= b2 (mod i m2)) (recur (inc i) z-candidate)
        :else (recur (inc i) (conj z-candidate i))))))

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
