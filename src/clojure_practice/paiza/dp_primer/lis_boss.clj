(ns clojure-practice.paiza.dp-primer.lis-boss
  (:require
   [clojure-practice.paiza.libs :refer [read-int-lines read-int-value-line]]))

(defn- read-input []
  (let [n (read-int-value-line)]
    [n (read-int-lines n)]))

(defn- lis-counts [n heights]
  (loop [idx 1
         counts [1]]
    (if (>= idx n)
      counts
      (let [current-height (nth heights idx)]
        (recur (inc idx)
               (conj counts
                     (reduce (fn [acc counts-idx]
                               (if (> (nth heights counts-idx) current-height)
                                 (max acc (inc (nth counts counts-idx)))
                                 acc))
                             1
                             (range idx))))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_lis_boss
   n 本の木が横一列に並んでいます。
   左から i 番目の木を木 i と呼ぶことにします。
   木 i の高さは a_i [cm] です。
   あなたは、何本かの木を伐採することによって、
   残った木を左から順に見ると高さが単調減少になっているようにしたいと考えています。
   つまり、残った木を左から 木 k_1, 木 k_2, ... ,
   木 k_m とすると、a_{k_1} > a_{k_2} > ... > a_{k_m} が満たされているようにしたいです。
   なるべく多くの木が残るように工夫して伐採する木を選んだとき、
   伐採されずに残る木の本数が最大でいくつになるか求めてください。
   なお、最初から n 本の木が単調減少に並んでいる場合は、1本も伐採しなくてよいものとします。"
  []
  (let [[n heights] (read-input)]
    (->> (lis-counts n heights)
         (apply max)
         (println))))
