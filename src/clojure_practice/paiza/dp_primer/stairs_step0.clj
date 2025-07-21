(ns clojure-practice.paiza.dp-primer.stairs-step0
  (:require
   [clojure-practice.paiza.libs :refer [read-int-value-line]]))

;; 引数で与えられた数値までの階段の上り方のパターン数を生成する
;; 1 歩で 1 段または 2 段を上ることができる
(defn- stairs-patterns-to [n]
  (loop [idx 2
         patterns [1 1]] ; 0段の階段を上る方法は1通り, 1段の階段を上る方法は1通り
    (if (> idx n)
      patterns
      (recur (inc idx)
             (conj patterns
                   (+ (nth patterns (- idx 1))
                      (nth patterns (- idx 2))))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_stairs_step0
   整数 n が与えられます。
   階段を上るのに、1 歩で 1 段または 2 段を上ることができるとき、
   n 段の階段を上る方法は何通りあるでしょうか。
   [input]
   ・ n
   [output]
   ・ n 段の階段を上る方法の数を1行に出力してください。"
  []
  (let [n (read-int-value-line)]
    (-> (stairs-patterns-to n)
        (last)
        (println))))
