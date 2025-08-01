(ns clojure-practice.paiza.graph-input-problems.adjacency-matrix-step3
  (:require
   [clojure-practice.paiza.libs :refer [read-int-value-line
                                        read-int-values-lines]]))

(defn- to-edges [adjacency-matrix n]
  (loop [i 0
         edges #{}]
    (if (<= n i)
      edges
      (recur (inc i)
             (reduce (fn [e j]
                       (if (= (get-in adjacency-matrix [i j]) 1)
                         (conj e #{i j})
                         e))
                     edges
                     (range n))))))

(defn main
  "https://paiza.jp/works/mondai/graph_input_problems/graph_input_problems__adjacency_matrix_step3
   1, ..., n の番号がついた n 個の頂点からなる無向グラフを考えます。
   整数 n と「隣接行列」が与えられます。このとき、このグラフに含まれる辺の個数を求めてください。
   [input]
   ・ 1 行目に、頂点の個数を表す整数 n が与えられます。
   ・ 続く n 行では、隣接行列の上から i 行目の n 個の整数が左から順に半角スペース区切りで与えられます。(1 ≦ i ≦ n)
   [output]
   辺の個数を表す整数を 1 行で出力してください。
   "
  []
  (let [n (read-int-value-line)
        adjacency-matrix (read-int-values-lines n)]
    (-> (to-edges adjacency-matrix n)
        (count)
        (println))))
