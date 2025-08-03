(ns clojure-practice.paiza.graph-input-problems.loops-multiple-edges-step1
  (:require
   [clojure-practice.paiza.libs :refer [read-int-value-line
                                        read-int-values-lines]]
   [clojure.string :as string]))

(defn- find-loops-edges [adjacency-matrix]
  (reduce (fn [acc i]
            (if (= 1 (get-in adjacency-matrix [i i]))
              (conj acc (inc i))
              acc))
          []
          (range (count adjacency-matrix))))

(defn- to-output [loops-edges]
  (if (empty? loops-edges)
    (str (count loops-edges))
    (str (count loops-edges) "\n" (string/join "\n" loops-edges))))

(defn main
  "https://paiza.jp/works/mondai/graph_input_problems/graph_input_problems__loops_multiple_edges_step1
   1, ..., n の番号がついた n 個の頂点からなる無向グラフを考えます。
   整数 n と、「隣接行列」が与えられます。
   このとき、次のような形式で表される「自己ループ」の辺が存在する頂点をすべて出力してください。
   [input]
   ・ 1 行目に、頂点の個数を表す整数 n が与えられます。
   ・ 続く n 行では、隣接行列の上から i 行目の n 個の整数が左から順に半角スペース区切りで与えられます。
   (1 ≦ i ≦ n)
   [output]
   「自己ループ」の辺が存在するような頂点の数を k として、合計 k + 1 行出力してください。
   1 行目には、「自己ループ」の辺が存在するような頂点の数 k を出力してください。
   続く k 行には、「自己ループ」の辺が存在するような頂点を、頂点の番号の昇順で改行区切りですべて出力してください。
   また、末尾に改行を入れ、余計な文字を含んではいけません。
   "
  []
  (let [n (read-int-value-line)
        adjacency-matrix (read-int-values-lines n)]
    (-> (find-loops-edges adjacency-matrix)
        (to-output)
        (println))))
