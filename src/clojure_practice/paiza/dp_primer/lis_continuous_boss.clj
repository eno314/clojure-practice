(ns clojure-practice.paiza.dp-primer.lis-continuous-boss
  (:require
   [clojure-practice.paiza.libs :refer [read-int-lines read-int-value-line]]))

(defn- read-input []
  (let [n (read-int-value-line)]
    [n (read-int-lines n)]))

(defn- reverse-order-counts [n heights]
  (loop [idx 1
         counts [1]]
    (if (>= idx n)
      counts
      (recur (inc idx)
             (conj counts
                   (if (>= (nth heights (dec idx)) (nth heights idx))
                     ; 前の人の身長が今の人の身長以上の場合は、カウンタをインクリメント
                     (inc (nth counts (dec idx)))
                     ; 前の人の身長が今の人の身長より低い場合は、カウンタを1にリセット
                     1))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_lis_continuous_boss
   n 人が横一列に並んでいます。左から i 番目の人を人 i と呼ぶことにします。
   人 i の身長は a_i [cm]です。
   人 l ,人 l+1, ... , 人 r からなる区間 [l, r] について、
   すべての l ≦ i < r に対して a_i ≧ a_{i+1} が成り立っているとき、
   区間 [l, r] は逆背の順であると呼ぶことにします。また、区間 [l, r] の長さを r-l+1 とします。
   逆背の順であるような区間のうち、最長であるものの長さを出力してください。
   [input]
   ・1行目に、横一列に並んでいる人の人数 n が与えられます。
   ・続く n 行のうち i 行目では、人 i の身長 a_i が与えられます。
   [output]
   ・逆背の順であるような区間のうち、最長であるものの長さを出力してください。
   "
  []
  (let [[n heights] (read-input)]
    (->> (reverse-order-counts n heights)
         (apply max)
         (println))))
