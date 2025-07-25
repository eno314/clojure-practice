(ns clojure-practice.paiza.dp-primer.partial-sums-step0
  (:require
   [clojure-practice.paiza.libs :refer [read-int-lines read-int-values-line]]))

;; dp[i][w] の i と w の 値を算出する
(defn- calc-dp-value-at [dp i w current-w]
  (let [prev-dp (nth dp (dec i))
        diff-w (- w current-w)
        create-with-current? (and (<= 0 diff-w)
                                  (nth prev-dp diff-w))
        create-without-current? (nth prev-dp w)]
    (or create-with-current? create-without-current?)))

;; dp[i][w] = 「i番目までのおもりを使い、重さの和がwとなるようにすることができるかどうか」
;; 上記のdpを計算する。
(defn- calc-dp [n goal-weight weights]
  (loop [i 1
         dp [(mapv #(= % 0) (range (inc goal-weight)))]] ; 重さ0のおもりを選ぶことはできる
    (if (> i n)
      dp
      (recur (inc i)
             (conj dp
                   (mapv #(calc-dp-value-at dp i % (nth weights (dec i)))
                         (range (inc goal-weight))))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_partial_sums_step0
   1 ~ n の番号がついた n 個のおもりがあり、おもり i の重さは a_i です。
   おもりを何個か選んで重さの和が x となるようにすることができるかどうか判定してください。
   なお、同じおもりを2個以上選ぶことはできません。
   [input]
   ・1行目に、おもりの個数 n と目標とする重さの和 x が半角スペース区切りで与えられます。
   ・続く n 行のうち i 行目では、おもり i の重さ a_i が与えられます。
   [output]
   ・おもりを何個か選んで重さの和が x となるようにすることができるなら yes と、できないなら no と出力してください。
   "
  []
  (let [[n goal-weight] (read-int-values-line)
        weights (read-int-lines n)]
    (as-> (calc-dp n goal-weight weights) result
      (get-in result [n goal-weight])
      (if result "yes" "no")
      (println result))))
