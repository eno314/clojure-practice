(ns clojure-practice.paiza.graph-input-problems.adjacency-matrix-step2
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]
   [clojure.string :as string]))

(defn- init-adjacency-matrix [n]
  (vec (repeat n (vec (repeat n 0)))))

(defn- update-adjacency-matrix [adjacency-matrix edges]
  (reduce (fn [updated-adjacency-matrix [y x]]
            (assoc-in updated-adjacency-matrix [(dec y) (dec x)] 1))
          adjacency-matrix
          edges))

(defn- to-output [adjacency-matrix]
  (string/join "\n" (mapv #(string/join " " %) adjacency-matrix)))

(defn main
  "https://paiza.jp/works/mondai/graph_input_problems/graph_input_problems__adjacency_matrix_step2
   1, ..., n の番号がついた n 個の頂点と、1, ..., m の番号がついた m 個の辺からなる有向グラフを考えます。
   整数 n, m と、m 個の頂点の組 (a_1, b_1), ..., (a_m, b_m) が与えられます。
   頂点の組 (a_i, b_i) は、頂点 a_i から 頂点 b_i に向かって辺が伸びていることを表します。
   そして、これら以外に辺はありません。このとき、「隣接行列」を出力してください。
   [input]
   ・ 1 行目に、頂点の個数を表す整数 n と、頂点の組の個数を表す整数 m が半角スペース区切りで与えられます。
   ・ 続く m 行では、頂点の組 a_i, b_i が半角スペース区切りで与えられます。(1 ≦ i ≦ m)
   [output]
   合計 n 行出力してください。
   i (1 ≦ i ≦ n) 行目には、隣接行列の上から i 行目の n 個の整数を左から順に半角スペース区切りで出力してください。
   また、末尾に改行を入れ、余計な文字、空行を含んではいけません。
   "
  []
  (let [[n m] (read-int-values-line)
        edges (read-int-values-lines m)]
    (-> (init-adjacency-matrix n)
        (update-adjacency-matrix edges)
        (to-output)
        (println))))
