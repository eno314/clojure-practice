(ns clojure-practice.paiza.graph-input-problems.adjacency-matrix-step1
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]
   [clojure.string :as string]))

(defn- init-adjacency-matrix [n]
  (vec (repeat n (vec (repeat n 0)))))

(defn- update-adjacency-matrix [adjacency-matrix edges]
  (reduce (fn [updated-adjacency-matrix [y x]]
            (-> (assoc-in updated-adjacency-matrix [(dec y) (dec x)] 1)
                (assoc-in [(dec x) (dec y)] 1)))
          adjacency-matrix
          edges))

(defn- to-output [adjacency-matrix]
  (string/join "\n" (mapv #(string/join " " %) adjacency-matrix)))

(defn main
  "https://paiza.jp/works/mondai/graph_input_problems/graph_input_problems__adjacency_matrix_step1
   頂点の組 (a_i, b_i) は、頂点 a_i と 頂点 b_i が辺で直接つながっていることを表します。
   (頂点 a_i と 頂点 b_i が辺で直接つながっているとき、頂点 b_i と 頂点 a_i も辺で直接つながっているといえます。)
   そして、これら以外に辺で直接つながっている頂点の組はありません。
   このとき、次のように定義される「隣接行列」を出力してください。
   > 縦 n 個、横 n 個の正方形型に n * n 個の整数を並べたもので、上から i 行目、左から j 列目の要素を
   > ・頂点 i と 頂点 j が辺で直接つながっていれば 1、そうでなければ 0
   > としたもの。
   ただし、a_i と b_i は異なる頂点であること、また同じ頂点の組は 2 回以上入力されないことが保証されます。
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
