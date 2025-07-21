(ns clojure-practice.paiza.dp-primer.apples-step1
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line]]))

;; 引数で与えられた数値+4(5-1)までの、丁度、同じ個数変えたときの価格一覧を返す
;; 同じ個数が買えない場合はLong/MAX_VALUEを返す
;; りんご2個が a 円で、りんご5個が b 円で売られている
(defn- min-apples-prices-by-2-5 [n a b]
  (loop [idx 1
         prices [0]]
    (if (> idx (+ n 4))
      prices
      (let [price-2 (if (< idx 2) Long/MAX_VALUE (nth prices (- idx 2)))
            price-5 (if (< idx 5) Long/MAX_VALUE (nth prices (- idx 5)))]
        (recur (inc idx)
               (conj prices
                     (min (if (= price-2 Long/MAX_VALUE) price-2 (+ price-2 a))
                          (if (= price-5 Long/MAX_VALUE) price-5 (+ price-5 b)))))))))

(defn- min-apples-prices [n apple-prices-by-2-5]
  (loop [idx 0
         prices [(first apple-prices-by-2-5)]]
    (if (> idx n)
      prices
      (let [targets (map #(nth apple-prices-by-2-5 %) (range idx (+ idx 5)))]
        (recur (inc idx)
               (conj prices
                     (apply min targets)))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_apples_step1
   八百屋にて、りんご2個が a 円で、りんご5個が b 円で売られています。
   りんごの買い方を工夫したとき、n 個のりんごを手に入れるために必要な金額の最小値はいくらでしょうか。
   なお、買い方を工夫した結果、買ったりんごが n+1 個以上になってもよいものとします。
   [input]
   ・'n a b'
   [output]
   ・りんごを n 個手に入れるために必要な金額の最小値を出力してください。"
  []
  (let [[n a b] (read-int-values-line)]
    (->> (min-apples-prices-by-2-5 n a b)
         (min-apples-prices n)
         (last)
         (println))))
