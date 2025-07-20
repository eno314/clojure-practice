(ns clojure-practice.paiza.dp-primer.stairs-step1
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line]]))

;; 引数で与えられた数値までの階段の上り方のパターン数を生成する
;; 1歩で a 段または b 段を上ることができる
(defn- stairs-patterns-to [n a b]
  (loop [idx 1
         patterns [1]]
    (cond
      (> idx n) patterns
      (and (< idx a)
           (< idx b)) (recur (inc idx)
                             (conj patterns 0))
      (< idx a) (recur (inc idx)
                       (conj patterns
                             (nth patterns (- idx b))))
      (< idx b) (recur (inc idx)
                       (conj patterns
                             (nth patterns (- idx a))))
      :else (recur (inc idx)
                   (conj patterns
                         (+ (nth patterns (- idx a))
                            (nth patterns (- idx b))))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_stairs_step1
   整数 n, a, b が与えられます。
   階段を上るのに、1歩で a 段または b 段を上ることができるとき、
   n 段の階段を上る方法は何通りあるでしょうか。
   n, a, b の値によっては答えが0になることがある
   (1歩で3段か5段上ることができるとき、ちょうど4段の階段を上る方法は存在しない)
   [input]
   ・ `n a b`
   [output]
   ・ n 段の階段を上る方法の数を1行に出力してください。"
  []
  (let [[n a b] (read-int-values-line)]
    (-> (stairs-patterns-to n a b)
        (last)
        (println))))
