(ns clojure-practice.atcoder.educational-dp-contest.knapsack1
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]))

(defn- calc-max-values [prev-max-values limit-weight [weight value]]
  (mapv #(if (< % weight)
           (nth prev-max-values %)
           (max (nth prev-max-values %)
                (+ (nth prev-max-values (- % weight)) value)))
        (range (inc limit-weight))))

(defn- calc-max-value-dp [n limit-weight items]
  (loop [idx 1
         dp [(vec (repeat (inc limit-weight) 0))]]
    (if (< n idx)
      dp
      (recur (inc idx)
             (conj dp (calc-max-values (last dp)
                                       limit-weight
                                       (nth items (dec idx))))))))

(defn- get-max-value [dp]
  (last (last dp)))

(defn main
  "https://atcoder.jp/contests/dp/tasks/dp_d
   N 個の品物があります。品物には 1,2,…,N と番号が振られています。
   各 i (1≤i≤N) について、品物 i の重さは wi で、価値は vi です。

   太郎君は、N 個の品物のうちいくつかを選び、
   ナップサックに入れて持ち帰ることにしました。
   ナップサックの容量は W であり、
   持ち帰る品物の重さの総和は W 以下でなければなりません。

   太郎君が持ち帰る品物の価値の総和の最大値を求めてください。

   [input]
   N W
   w1 v1
   w2 v2
   :
   wN vN
   [output]
   太郎君が持ち帰る品物の価値の総和の最大値を出力せよ。
   "
  []
  (let [[n w] (read-int-values-line)
        items (read-int-values-lines n)]
    (-> (calc-max-value-dp n w items)
        (get-max-value)
        (println))))
