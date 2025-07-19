(ns clojure-practice.paiza.grid-dijkstra.d0
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]))

(defn- read-first-line []
  (as-> (read-int-values-line) int-values
    {:h (first int-values)
     :w (second int-values)}))

(defn- read-grid [hw]
  (read-int-values-lines (get hw :h)))

(defn- calc-fixed-move-cost [grid]
  (+ (get-in grid [0 0])
     (get-in grid [0 1])
     (get-in grid [1 1])
     (get-in grid [1 2])
     (get-in grid [0 2])
     (get-in grid [0 1])))

(defn main
  "https://paiza.jp/works/mondai/grid_dijkstra/grid_dijkstra__d0
   グリッド状の盤面の左上からスタートして、
   「右、下、右、上、左」と順に移動したときの経路上のマスのコストの合計を求める
   ・ 1 行目には盤面の行数を表す h , 盤面の列数を表す w が与えられます。
   ・ 続く h 行のうち i 行目には、i 行目のマスのコストを表す整数値のリスト t_i が与えられます。
   ・ t_{i,j} は i 行目の j 列目のコストです。"
  []
  (->> (read-first-line)
       (read-grid)
       (calc-fixed-move-cost)
       (println)))
