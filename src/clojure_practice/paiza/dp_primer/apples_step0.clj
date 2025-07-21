(ns clojure-practice.paiza.dp-primer.apples-step0
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line]]))

;; 引数で与えられた数値までのりんごの最小金額を生成する
;; りんご1個が a 円で、りんご2個が b 円で売られている
(defn- min-apples-prices [n a b]
  (loop [idx 2
         prices [0 a]]
    (if (> idx n)
      prices
      (recur (inc idx)
             (conj prices
                   (min (+ (nth prices (- idx 1)) a)
                        (+ (nth prices (- idx 2)) b)))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_apples_step0
   八百屋にて、りんご1個が a 円で、りんご2個が b 円で売られています。
   りんごの買い方を工夫したとき、n 個のりんごを手に入れるために必要な金額の最小値はいくらでしょうか。
   なお、買い方を工夫した結果、買ったりんごが n+1 個以上になってもよいものとします。
   [input]
   ・'n a b'
   [output]
   ・りんごを n 個手に入れるために必要な金額の最小値を出力してください。"
  []
  (let [[n a b] (read-int-values-line)]
    (-> (min-apples-prices n a b)
        (last)
        (println))))
