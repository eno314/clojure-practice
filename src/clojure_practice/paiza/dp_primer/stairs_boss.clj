(ns clojure-practice.paiza.dp-primer.stairs-boss
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line]]))

;; 引数で与えられた数値までの階段の上り方のパターン数を生成する
;; 1歩で a 段または b 段または c 段を上ることができる
(defn- stairs-patterns-to [n a b c]
  (loop [idx 1
         patterns [1]]
    (if (> idx n)
      patterns
      (recur (inc idx)
             (conj patterns
                   (+ (if (< idx a) 0 (nth patterns (- idx a)))
                      (if (< idx b) 0 (nth patterns (- idx b)))
                      (if (< idx c) 0 (nth patterns (- idx c)))))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_stairs_boss
   整数 n, a, b, c が与えられます。
   階段を上るのに、1歩で a 段または b 段または c 段を上ることができるとき、
   n 段の階段を上る方法は何通りあるでしょうか。
   [input]
   ・ `n a b c`
   [output]
   ・ n 段の階段を上る方法の数を1行に出力してください。"
  []
  (let [[n a b c] (read-int-values-line)]
    (-> (stairs-patterns-to n a b c)
        (last)
        (println))))
