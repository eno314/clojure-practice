(ns clojure-practice.paiza.euclidean-primer.fraction
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

(defn- calculate-fraction
  [[a b cal c d]]
  (let [a-num (Long/parseLong a)
        b-num (Long/parseLong b)
        c-num (Long/parseLong c)
        d-num (Long/parseLong d)
        numerator (cond
                    (= cal "+") (+ (* a-num d-num) (* b-num c-num))
                    (= cal "-") (- (* a-num d-num) (* b-num c-num))
                    (= cal "*") (* a-num c-num)
                    (= cal "/") (* a-num d-num))
        denominator (if (= cal "/")
                      (* b-num c-num)
                      (* b-num d-num))
        nd-gcd (gcd [numerator denominator])]
    [(/ numerator nd-gcd) (/ denominator nd-gcd)]))

(defn normalize
  [[numerator denominator]]
  (if (neg? denominator)
    [(- numerator) (- denominator)]
    [numerator denominator]))

(defn main
  []
  (->> (string/split (read-line) #" ")
       (calculate-fraction)
       (normalize)
       (string/join " ")
       (println)))
