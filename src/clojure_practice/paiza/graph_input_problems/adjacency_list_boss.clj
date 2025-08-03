(ns clojure-practice.paiza.graph-input-problems.adjacency-list-boss
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]
   [clojure.string :as string]))

(defn- init-adjacency-matrix [n]
  (vec (repeat n (vec (repeat n 0)))))

(defn- update-adjacency-matrix [adjacency-matrix edges]
  (reduce (fn [updated-adjacency-matrix [y x w]]
            (assoc-in updated-adjacency-matrix [(dec y) (dec x)] w))
          adjacency-matrix
          edges))

(defn- to-adjacency-edges-matrix [adjacency-matrix]
  (mapv #(reduce (fn [acc i]
                   (let [weight (nth % i)]
                     (if (< 0 weight)
                       (conj acc weight)
                       acc)))
                 []
                 (range (count %)))
        adjacency-matrix))

(defn- to-output [to-adjacency-edges-matrix]
  (string/join "\n"
               (mapv #(if (empty? %) "-1" (string/join " " %))
                     to-adjacency-edges-matrix)))

(defn main
  "https://paiza.jp/works/mondai/graph_input_problems/graph_input_problems__adjacency_list_boss
   1, ..., n の番号がついた n 個の頂点と、1, ..., m の番号がついた m 個の辺からなる重みつき有向グラフを考えます。
   整数 n, m と、m 個の頂点の組と重みの整数 (a_1, b_1, w_i), ..., (a_m, b_m, w_i) が与えられます。
   頂点の組と重みの整数 (a_i, b_i, w_i) は、頂点 a_i から 頂点 b_i に向かって辺が伸びていて、その辺につけられた重みが整数 w_i であることを表します。
   そして、これら以外に辺はありません。このとき、「隣接リストの重みの部分」を出力してください。
   [input]
   ・ 1 行目に、頂点の個数を表す整数 n と、頂点の組の個数を表す整数 m が半角スペース区切りで与えられます。
   ・ 続く m 行では、頂点の組と重みの整数 a_i, b_i, w_i が半角スペース区切りで与えられます。(1 ≦ i ≦ m)
   [output]
   合計 n 行出力してください。
   i (1 ≦ i ≦ n) 行目には、隣接リストの上から i 行目の整数を左から順に半角スペース区切りで出力してください。
   ただし、i 行目が空である場合は、-1 を出力してください。
   "
  []
  (let [[n m] (read-int-values-line)
        edges (read-int-values-lines m)]
    (-> (init-adjacency-matrix n)
        (update-adjacency-matrix edges)
        (to-adjacency-edges-matrix)
        (to-output)
        (println))))
