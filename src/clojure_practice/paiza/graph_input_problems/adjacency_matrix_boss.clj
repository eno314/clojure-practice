(ns clojure-practice.paiza.graph-input-problems.adjacency-matrix-boss
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]
   [clojure.string :as string]))

(defn- to-edges [adjacency-matrix n]
  (loop [i 0
         edges #{}]
    (if (<= n i)
      edges
      (recur (inc i)
             (reduce (fn [e j]
                       (if (= (get-in adjacency-matrix [i j]) 1)
                         (conj e #{(inc i) (inc j)})
                         e))
                     edges
                     (range n))))))

(defn- to-output [edges target-pairs]
  (->> target-pairs
       (map (fn [[a b]] (if (contains? edges #{a b}) 1 0)))
       (string/join "\n")))

(defn main
  "https://paiza.jp/works/mondai/graph_input_problems/graph_input_problems__adjacency_matrix_boss
   1, ..., n の番号がついた n 個の頂点からなる無向グラフを考えます。
   整数 n, q と「隣接行列」が与えられます。
   q 個の整数の組 (a_1, b_1), ... , (a_q, b_q) が与えられるので、それぞれ 頂点 a_i と頂点 b_i が辺で直接つながっているか判定し、辺で直接つながっていれば 1 を、そうでなければ 0 を出力してください。
   a_i と b_i は異なる頂点であることが保証されます。
   [input]
   ・ 1 行目に、頂点の個数を表す整数 n, 整数の組の個数を表す整数 q が半角スペース区切りで与えられます。
   ・ 続く n 行では、隣接行列の上から i 行目の n 個の整数が、半角スペース区切りで与えられます。(1 ≦ i ≦ n)
   ・ 続く q 行では、頂点の組 a_i, b_i が半角スペース区切りで与えられます。(1 ≦ i ≦ q)
   [output]
   合計 q 行出力してください。
   i (1 ≦ i ≦ q) 行目には、頂点 a_i と頂点 b_i が辺で直接つながっていれば 1 を、そうでなければ 0 を 1 行で出力してください。
   "
  []
  (let [[n q] (read-int-values-line)
        adjacency-matrix (read-int-values-lines n)
        target-pairs (read-int-values-lines q)]
    (-> (to-edges adjacency-matrix n)
        (to-output target-pairs)
        (println))))
