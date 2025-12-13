(ns clojure-practice.paiza.euclidean-primer.multi-gcd)

(defn- get-numbers-from-input
  []
  (let [size (Long/parseLong (read-line))]
    (map #(Long/parseLong %)
         (take size (repeatedly read-line)))))

(defn- gcd
  [[a b]]
  (loop [x a
         y b]
    (cond
      (zero? x) y
      (zero? y) x
      (< x y) (recur x (mod y x))
      :else (recur y (mod x y)))))

(defn- multi-gcd
  [numbers]
  (reduce (fn [acc n] (gcd [acc n])) numbers))

(defn main
  []
  (->> (get-numbers-from-input)
       (multi-gcd)
       (println)))
