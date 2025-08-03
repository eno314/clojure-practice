(ns clojure-practice.paiza.graph-input-problems.adjacency-list-step1
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

(defn- to-output-line [adjacency-matrix-line]
  (let [adjacency-edges (reduce (fn [acc i]
                                  (if (= 1 (nth adjacency-matrix-line i))
                                    (conj acc (inc i))
                                    acc))
                                []
                                (range (count adjacency-matrix-line)))]
    (if (empty? adjacency-edges)
      "-1"
      (string/join " " adjacency-edges))))

(defn- to-adjacency-edges-matrix [adjacency-matrix]
  (mapv #(reduce (fn [acc i]
                   (if (= 1 (nth % i))
                     (conj acc (inc i))
                     acc))
                 []
                 (range (count %)))
        adjacency-matrix))

(defn- to-output [to-adjacency-edges-matrix]
  (string/join "\n"
               (mapv #(if (empty? %) "-1" (string/join " " %))
                     to-adjacency-edges-matrix)))

(defn main
  "https://paiza.jp/works/mondai/graph_input_problems/graph_input_problems__adjacency_list_step1
   1, ..., n の番号がついた n 個の頂点と、1, ..., m の番号がついた m 個の辺からなる無向グラフを考えます。
   整数 n, m と、m 個の頂点の組 (a_1, b_1), ..., (a_m, b_m) が与えられます。
   頂点の組 (a_i, b_i) は、頂点 a_i と 頂点 b_i が辺で直接つながっていることを表します。
   (頂点 a_i と 頂点 b_i が辺で直接つながっているとき、頂点 b_i と 頂点 a_i も辺で直接つながっているといえます。)
   そして、これら以外に辺で直接つながっている頂点の組はありません。このときの「隣接リスト」を出力してください。
   ただし、a_i と b_i は異なる頂点であること、また同じ頂点の組は 2 回以上入力されないことが保証されます。
   [input]
   ・ 1 行目に、頂点の個数を表す整数 n と、頂点の組の個数を表す整数 m が半角スペース区切りで与えられます。
   ・ 続く m 行では、頂点の組 a_i, b_i が半角スペース区切りで与えられます。(1 ≦ i ≦ m)
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
