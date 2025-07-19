(ns clojure-practice.paiza.grid-dijkstra.d1
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]))

(def DISABLED_GRID_VALUE 1)

(def DISABLED_POINT_VALUE -1)
(def NOT_VISITED_POINT_VALUE 0)

(defn- read-input []
  (let [int-values (read-int-values-line)
        h (first int-values)]
    {:h h
     :w (second int-values)
     :grid (read-int-values-lines h)}))

(defn- init-distances [{:keys [grid]}]
  (-> (mapv (fn [row]
              (mapv #(if (= % DISABLED_GRID_VALUE)
                       DISABLED_POINT_VALUE
                       NOT_VISITED_POINT_VALUE)
                    row))
            grid)
      ; 先頭のコストを1にしておく
      (assoc-in [0 0] 1)))

(defn- candidate? [distances pos]
  (as-> (get-in distances pos) result
    (and (not (nil? result))
         (= result NOT_VISITED_POINT_VALUE))))

(defn- update-calc-loop-args [distances queue-to-visit next-pos next-distance]
  (if (candidate? distances next-pos)
    [(assoc-in distances next-pos next-distance) (conj queue-to-visit next-pos)]
    [distances queue-to-visit]))

(defn- calc-shortest-distances [distances]
  (loop [d distances
         queue-to-visit (conj clojure.lang.PersistentQueue/EMPTY [0 0])]
    (if (empty? queue-to-visit)
      d
      (let [current-pos (peek queue-to-visit)
            next-d (inc (get-in d current-pos))
            right-pos (assoc current-pos 1 (inc (second current-pos)))
            below-pos (assoc current-pos 0 (inc (first current-pos)))
            left-pos (assoc current-pos 1 (dec (second current-pos)))
            top-pos (assoc current-pos 0 (dec (first current-pos)))]
        (as-> (update-calc-loop-args d (pop queue-to-visit) right-pos next-d) args
          (update-calc-loop-args (first args) (second args) below-pos next-d)
          (update-calc-loop-args (first args) (second args) left-pos next-d)
          (update-calc-loop-args (first args) (second args) top-pos next-d)
          (recur (first args) (second args)))))))


(defn main
  "https://paiza.jp/works/mondai/grid_dijkstra/grid_dijkstra__d1h
   グリッド状の盤面で上下左右の移動を繰り返して、
   左上のスタートから右下のゴールまで移動するときに通るマス (スタート、ゴール含む) の最小の個数を求めてください。
   ただし、0 のマスは通れて、1 のマスは通れません。
   なお、0 のマスのみを通ってスタートからゴールまで移動できることが保証されています。
   ・ 1 行目には盤面の行数を表す h , 盤面の列数を表す w が与えられます。
   ・ 続く h 行のうち i 行目には、盤面 の i 行目を表す整数値のリスト t_i が与えられます。
   ・ t_{i,j} は i 行目の j 列目の値です。"
  []
  (-> (read-input)
      (init-distances)
      (calc-shortest-distances)
      (last)
      (last)
      (println)))
