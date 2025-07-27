(ns clojure-practice.atcoder.educational-dp-contest.frog2
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line]]))

(defn- calc-cost-from-to [costs dp from to]
  (+ (nth dp from)
     (Math/abs (- (nth costs from) (nth costs to)))))

(defn calc-costs-dp [n k costs]
  (loop [idx 2
         dp [0 (calc-cost-from-to costs [0] 0 1)]]
    (if (<= n idx)
      dp
      (recur (inc idx)
             (conj dp
                   (apply min (map #(calc-cost-from-to costs dp (- idx %) idx)
                                   (range 1 (inc (min k idx))))))))))

(defn main
  "https://atcoder.jp/contests/dp/tasks/dp_a
   N 個の足場があります。足場には 1,2,…,N と番号が振られています。
   各 i (1≤i≤N) について、足場 i の高さは hi です。
   最初、足場 1 にカエルがいます。 カエルは次の行動を何回か繰り返し、足場 N まで辿り着こうとしています。
   ・足場 i にいるとき、足場 i+1,i+2,…,i+K のどれかへジャンプする。
   ・このとき、ジャンプ先の足場を j とすると、コスト |hi - hj| を支払う。
   カエルが足場 N に辿り着くまでに支払うコストの総和の最小値を求めてください。
   [input]
   N K
   h1 h2 … hN
   [output]
   カエルが支払うコストの総和の最小値を出力せよ。
   "
  []
  (let [[n k] (read-int-values-line)
        costs (read-int-values-line)]
    (-> (calc-costs-dp n k costs)
        (last)
        (println))))
