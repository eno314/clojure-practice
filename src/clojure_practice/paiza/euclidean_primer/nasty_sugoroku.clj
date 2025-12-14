(ns clojure-practice.paiza.euclidean-primer.nasty-sugoroku
  (:require
   [clojure.string :as string]))

(defn gcd
  [[a b]]
  (loop [x (Math/abs a)
         y (Math/abs b)]
    (cond
      (zero? x) y
      (zero? y) x
      (< x y) (recur x (mod y x))
      :else (recur y (mod x y)))))

(defn- nasty-sugoroku
  [[n a]]
  (if (zero? (mod n a))
    []
    (filter #(not (or (= a %)
                      (zero? (mod n %))
                      ;; ax + by = gcd(a, n).
                      ;; So there is no solution when `n % gcd(a, b) != 0`
                      (zero? (mod n (gcd [a %])))))
            (range 1 1001))))

(defn- create-output-str
  [results]
  (if (empty? results)
    "-1"
    (string/join "\n" results)))

(defn main
  []
  (->> (map #(Long/parseLong %) (string/split (read-line) #" "))
       (nasty-sugoroku)
       (create-output-str)
       (println)))
