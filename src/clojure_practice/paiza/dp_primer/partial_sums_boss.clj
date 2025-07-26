(ns clojure-practice.paiza.dp-primer.partial-sums-boss
  (:require
   [clojure-practice.paiza.libs :refer [read-int-lines read-int-values-line]]))

; dp[i][w] の i と w の 値を算出する
(defn- calc-can-create-dp-at [dp i w current-w]
  (let [prev-dp (nth dp (dec i))
        create-without-current? (nth prev-dp w)]
    (if create-without-current?
      true
      (loop [diff-w (- w current-w)
             result false]
        (if (or result (< diff-w 0))
          result
          (recur (- diff-w current-w)
                 (nth prev-dp diff-w)))))))

;; dp[i][w] = 「i番目までのおもりを使い、重さの和がwとなるようにすることができるかどうか」
;; 上記のdpを計算する。
(defn- calc-can-create-dp [n goal-weight weights]
  (loop [i 1
         dp [(mapv #(= % 0) (range (inc goal-weight)))]]
    (if (> i n)
      dp
      (recur (inc i)
             (conj dp
                   (mapv #(calc-can-create-dp-at dp i % (nth weights (dec i)))
                         (range (inc goal-weight))))))))

(defn- to-output [dp n goal-weight]
  (let [create? (get-in dp [n goal-weight])]
    (if create? "yes" "no")))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_partial_sums_boss
   1 ~ n の番号がついた n 種類のおもりがあり、おもり i の重さは a_i です。
   それぞれのおもりは無限個存在しており、任意のおもりを任意の個数使うことができます。
   このとき、おもりを選んで重さの和を x となるようにすることができるかどうか判定してください。
   [input]
   ・1行目に、おもりの種類数 n と目標とする重さの和 x が半角スペース区切りで与えられます。
   ・続く n 行のうち i 行目では、おもり i の重さ a_i が与えられます。
   [output]
   重さの和が x となるようにおもりを選ぶことができるなら yes と、できないなら no と出力してください。
   また、末尾に改行を入れ、余計な文字、空行を含んではいけません。
   "
  []
  (let [[n goal-weight] (read-int-values-line)
        weights (read-int-lines n)]
    (-> (calc-can-create-dp n goal-weight weights)
        (to-output n goal-weight)
        (println))))
