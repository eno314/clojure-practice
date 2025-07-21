(ns clojure-practice.paiza.dp-primer.apples-step2
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line]]))

(defn- read-input []
  (let [[n x a y b] (read-int-values-line)]
    {:n n,
     :fst-count x,
     :fst-price a,
     :snd-count y,
     :snd-price b,
     :max-count (max x y)}))

;; 引数で与えられた数値+(max-count-1)までの、丁度、同じ個数変えたときの価格一覧を返す
;; 同じ個数が買えない場合はLong/MAX_VALUEを返す
(defn- min-apples-prices-just [{:keys [n fst-count fst-price snd-count snd-price max-count]}]
  (loop [idx 1
         prices [0]]
    (if (> idx (+ n (dec max-count)))
      prices
      (let [fst-total (if (< idx fst-count) Long/MAX_VALUE (nth prices (- idx fst-count)))
            snd-total (if (< idx snd-count) Long/MAX_VALUE (nth prices (- idx snd-count)))]
        (recur (inc idx)
               (conj prices
                     (min (if (= fst-total Long/MAX_VALUE) fst-total (+ fst-total fst-price))
                          (if (= snd-total Long/MAX_VALUE) snd-total (+ snd-total snd-price)))))))))

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
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_apples_step2
   八百屋にて、りんご x 個が a 円で、りんご y 個が b 円で売られています。
   りんごの買い方を工夫したとき、最終的に n 個のりんごを手に入れるために必要な金額の最小値はいくらでしょうか。
   なお、買い方を工夫した結果、買ったりんごが n+1 個以上になってもよいものとします。
   [input]
   ・'n x a y b'
   [output]
   ・りんごを n 個手に入れるために必要な金額の最小値を出力してください。"
  []
  (let [input (read-input)]
    (->> (min-apples-prices-just input)
         (min-apples-prices input)
         (last)
         (println))))
