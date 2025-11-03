(ns clojure-practice.paiza.prime-number-primer.is-prime)

(defn- primer?
  [n]
  (cond
    (<= n 1) false
    (= n 2) true
    :else (not-any? #(zero? (mod n %))
                    (range 2 (inc (Math/sqrt n))))))

(defn- update-sieve
  [sieve prime]
  (loop [multiple (* 2 prime)
         updated-sieve sieve]
    (if (> multiple (dec (count sieve)))
      updated-sieve
      (recur (+ multiple prime)
             (assoc updated-sieve multiple false)))))

(defn- eratosthenes-sieve
  [n]
  (let [init-sieve (vec (concat [false, false]
                                (vec (repeat (dec n) true))))]
    (loop [i 2
           sieve init-sieve]
      (if (> i n)
        sieve
        (if (false? (get sieve i))
          (recur (inc i) sieve)
          (recur (inc i) (update-sieve sieve i)))))))

(defn- primer?-by-fermat
  [n]
  (cond
    (<= n 1) false
    (= n 2) true
    :else (let [a 2] ; fix a to 2 for simplicity
            (= 1
               (reduce (fn [acc _] (mod (* acc a) n))
                       1
                       (range (dec n)))))))
(defn- boolean-to-string
  [b]
  (if b "YES" "NO"))

(defn main
  []
  (->> (Long/parseLong (read-line))
       (primer?)
       (boolean-to-string)
       (println)))
