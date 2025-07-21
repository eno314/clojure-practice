(ns clojure-practice.paiza.dp-primer.apples-boss
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line]]))

(defn- read-input []
  (let [[n x a y b z c] (read-int-values-line)]
    {:n n,
     :fst-count x,
     :fst-price a,
     :snd-count y,
     :snd-price b,
     :trd-count z,
     :trd-price c,
     :max-count (max x y z)}))

(defn- get-total-price-from [prices idx count price]
  (let [total-price-of-idx (if (< idx count)
                             Long/MAX_VALUE
                             (nth prices (- idx count)))]
    (if (= total-price-of-idx Long/MAX_VALUE)
      total-price-of-idx
      (+ total-price-of-idx price))))

;; 引数で与えられた数値+(max-count-1)までの、丁度、同じ個数変えたときの価格一覧を返す
;; 同じ個数が買えない場合はLong/MAX_VALUEを返す
(defn- min-apples-prices-just [{:keys [n max-count
                                       fst-count fst-price
                                       snd-count snd-price
                                       trd-count trd-price]}]
  (loop [idx 1
         prices [0]]
    (if (> idx (+ n (dec max-count)))
      prices
      (recur (inc idx)
             (conj prices
                   (min (get-total-price-from prices idx fst-count fst-price)
                        (get-total-price-from prices idx snd-count snd-price)
                        (get-total-price-from prices idx trd-count trd-price)))))))

(defn- min-apples-prices [{:keys [n max-count]} prices-just]
  (loop [idx 0
         prices [(first prices-just)]]
    (if (> idx n)
      prices
      (let [targets (map #(nth prices-just %) (range idx (+ idx max-count)))]
        (recur (inc idx)
               (conj prices
                     (apply min targets)))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_apples_boss
   八百屋にて、りんご x 個が a 円で、りんご y 個が b 円で、りんご z 個が c 円で売られています。
   りんごの買い方を工夫したとき、n 個のりんごを手に入れるために必要な金額の最小値はいくらでしょうか。
   なお、買い方を工夫した結果、買ったりんごが n+1 個以上になってもよいものとします。
   [input]
   ・'n x a y b z c'
   [output]
   ・りんごを n 個手に入れるために必要な金額の最小値を出力してください。"
  []
  (let [input (read-input)]
    (->> (min-apples-prices-just input)
         (min-apples-prices input)
         (last)
         (println))))
