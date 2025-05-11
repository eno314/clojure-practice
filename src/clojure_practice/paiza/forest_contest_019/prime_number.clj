(ns clojure-practice.paiza.forest-contest-019.prime-number)

(defn- divisible? [target divider]
  (zero? (mod target divider)))

(defn- prime-number? [target-num]
  (cond
    (< target-num 2) false
    (= target-num 2) true
    (even? target-num) false
    :else (let [range-limit (inc (long (Math/sqrt target-num)))
                target-range (range 3 range-limit 2)]
            (not-any? #(divisible? target-num %) target-range))))
  ;(loop [numbers (range 2 (inc target-num))]
  ;  (let [prime-num (first numbers)
  ;        rest-numbers (rest numbers)]
  ;    (if (empty? rest-numbers)
  ;      (= prime-num target-num)
  ;      (recur (filterv
  ;              #(not (divisible? % prime-num))
  ;              rest-numbers))))))

(defn main []
  (as-> (Long/parseLong (read-line)) n
    (if (prime-number? n)
      (println "Yes")
      (println "No"))))
