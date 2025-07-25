(ns clojure-practice.paiza.dp-primer.partial-sums-step1
  (:require
   [clojure-practice.paiza.libs :refer [read-int-lines read-int-values-line]]))

(def MOD 1000000007)

;; i w の dp の値を算出する
(defn- calc-num-of-cases-dp-at [dp i w current-w]
  (let [prev-dp (nth dp (dec i))
        diff-w (- w current-w)
        num-of-cases-with-current (if (<= 0 diff-w) (nth prev-dp diff-w) 0)
        num-of-cases-without-current (nth prev-dp w)]
    (mod (+ num-of-cases-with-current num-of-cases-without-current) MOD)))

;; dp[i][w] = 「i番目までのおもりを使い、重さの和がwとなるようにする方法が何通りあるか」
;; 上記のdpを計算する。
(defn- calc-num-of-cases-dp [n goal-weight weights]
  (loop [i 1
         dp [(mapv #(if (= % 0) 1 0) (range (inc goal-weight)))]]
    (if (> i n)
      dp
      (recur (inc i)
             (conj dp
                   (mapv #(calc-num-of-cases-dp-at dp i % (nth weights (dec i)))
                         (range (inc goal-weight))))))))

(defn- get-num-of-cases-at [dp n goal-weight]
  (let [dp-at (get-in dp [n goal-weight])]
    (if (nil? dp-at)
      0
      dp-at)))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_partial_sums_step1
   1 ~ n の番号がついた n 個のおもりがあり、おもり i の重さは a_i です。
   おもりを何個か選んで重さの和が x となるようにする方法が何通りあるか求めてください。
   なお、同じおもりを2個以上選ぶことはできません。
   重さが同じおもりが複数存在する場合、それらは区別して別のものとして扱うことにします。
   答えは非常に大きくなる可能性があるので、答えを 1,000,000,007 で割った余りで出力してください。
   [input]
   ・1行目に、おもりの個数 n と目標とする重さの和 x が半角スペース区切りで与えられます。
   ・続く n 行のうち i 行目では、おもり i の重さ a_i が与えられます。
   [output]
   ・重さの和が x となるようにおもりを選ぶ方法が何通りあるか求めてください。
   ・ただし、答えは非常に大きくなる可能性があるので、1,000,000,007 で割った余りで出力してください。
   "
  []
  (let [[n goal-weight] (read-int-values-line)
        weights (read-int-lines n)]
    (-> (calc-num-of-cases-dp n goal-weight weights)
        (get-num-of-cases-at n goal-weight)
        (println))))
