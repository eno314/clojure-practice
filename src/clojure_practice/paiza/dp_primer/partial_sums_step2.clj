(ns clojure-practice.paiza.dp-primer.partial-sums-step2
  (:require
   [clojure-practice.paiza.libs :refer [read-int-lines read-int-values-line]]))

(def INF (dec Long/MAX_VALUE))

;; i w の dp の値を算出する
(defn- calc-num-of-weights-dp-at [dp i w current-w]
  (let [prev-dp (nth dp (dec i))
        diff-w (- w current-w)
        num-of-weights-with-current (inc (if (<= 0 diff-w) (nth prev-dp diff-w) INF))
        num-of-weights-without-current (nth prev-dp w)]
    (min num-of-weights-with-current num-of-weights-without-current)))

;; dp[i][w] = 「i番目までのおもりを使い、重さの和がwとなるようにする方法が何通りあるか」
;; 上記のdpを計算する。
(defn- calc-num-of-weights-dp [n goal-weight weights]
  (loop [i 1
         dp [(mapv #(if (= % 0) 0 INF) (range (inc goal-weight)))]]
    (if (> i n)
      dp
      (recur (inc i)
             (conj dp
                   (mapv #(calc-num-of-weights-dp-at dp i % (nth weights (dec i)))
                         (range (inc goal-weight))))))))

(defn- get-num-of-weights-at [dp n goal-weight]
  (let [dp-at (get-in dp [n goal-weight])]
    (if (= dp-at INF)
      -1
      dp-at)))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_partial_sums_step2
   1 ~ n の番号がついた n 個のおもりがあり、おもり i の重さは a_i です。
   おもりを何個か選んで重さの和が x となるようにする方法を考えたとき、
   選ぶおもりの個数の最小値を出力してください。
   なお、同じおもりを2個以上選ぶことはできません。
   なお、重さの和が x となるようにおもりを選ぶ方法が存在しない場合は-1と出力してください。"
  []
  (let [[n goal-weight] (read-int-values-line)
        weights (read-int-lines n)]
    (-> (calc-num-of-weights-dp n goal-weight weights)
        (get-num-of-weights-at n goal-weight)
        (println))))
