(ns clojure-practice.paiza.euclidean-primer.rsa-verification)

(def P 99991)
(def Q 99989)
(def ORIGINAL-STRING "WOW!")

(defn- encode-string
  [s]
  (reduce (fn [acc c]
            (+ (* acc 128) (int c)))
          0
          s))

(defn- mod-pow
  [[a e m]]
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

(defn main
  []
  (let [n (* (bigint P) (bigint Q))
        e 65537
        m (encode-string ORIGINAL-STRING)
        e' (mod-pow [m e n])]
    (println (str n) (str e) (str e'))
    (println ORIGINAL-STRING)))
