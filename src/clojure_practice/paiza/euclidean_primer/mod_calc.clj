(ns clojure-practice.paiza.euclidean-primer.mod-calc
  (:require
   [clojure.string :as string]))

(defn- mod-pow
  [a e m]
  (loop [a' (mod a m)
         e' e
         acc 1]
    (if (zero? e')
      acc
      (recur (mod (* a' a') m)
             (quot e' 2)
             (if (odd? e')
               (mod (* acc a') m)
               acc)))))

(defn- calculate-mod
  [[a-str op b-str] n]
  (let [a (Long/parseLong a-str)
        b (Long/parseLong b-str)]
    (case op
      "+" (mod (+ a b) n)
      "-" (mod (- a b) n)
      "*" (mod (* a b) n)
      "^" (mod-pow a b n))))

(defn main
  []
  (let [n (Long/parseLong (read-line))]
    (-> (string/split (read-line) #" ")
        (calculate-mod n)
        (println))))
