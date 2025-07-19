(ns clojure-practice.paiza.grid-dijkstra.d1
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]))

;; 入力データの定数値
(def DISABLED_INPUT_GRID_VALUE 1)

;; 計算時に使う定数値
(def DISABLED_GRID_VALUE -1)
(def NOT_VISITED_GRID_VALUE 0)
(def START_GRID_DISTANCE 1)

;; 入力データを読み込み、グリッドの高さ・幅・マップデータを取得
(defn- read-input []
  (let [[height width] (read-int-values-line)]
    [height width (read-int-values-lines height)]))

;; グリッドを初期化：通れないマスと通れるマスを変換し、スタート位置の距離を設定
(defn- init-grid [input-grid]
  (let [grid (mapv (fn [row]
                     (mapv #(if (= % DISABLED_INPUT_GRID_VALUE)
                              DISABLED_GRID_VALUE
                              NOT_VISITED_GRID_VALUE)
                           row))
                   input-grid)]
    (assoc-in grid [0 0] START_GRID_DISTANCE)))

;; 指定された位置がグリッド内の有効な座標かチェック
(defn- valid-position? [[height width] [row col]]
  (and (>= row 0) (< row height) (>= col 0) (< col width)))


;; 指定された位置の上下左右の隣接位置を取得
(defn- neighbors [[row col]]
  [[(inc row) col] [row (inc col)] [(dec row) col] [row (dec col)]])

;; 現在位置から隣接する位置を訪問し、距離を更新してキューに追加
(defn- visit-neighbors [distance-grid height-width current-pos queue-to-visit]
  (let [current-distance (get-in distance-grid current-pos)
        next-distance (inc current-distance)]
    (reduce (fn [[grid queue] neighbor]
              (if (and (valid-position? height-width neighbor)
                       (= (get-in grid neighbor) NOT_VISITED_GRID_VALUE))
                [(assoc-in grid neighbor next-distance) (conj queue neighbor)]
                [grid queue]))
            [distance-grid queue-to-visit]
            (neighbors current-pos))))

;; 幅優先探索で最短経路の距離を計算
(defn- calculate-shortest-path [distance-grid height-width]
  (loop [grid distance-grid
         pos-to-visit (conj clojure.lang.PersistentQueue/EMPTY [0 0])]
    (if (empty? pos-to-visit)
      grid
      (let [current-position (peek pos-to-visit)
            [updated-grid updated-queue] (visit-neighbors grid
                                                          height-width
                                                          current-position
                                                          (pop pos-to-visit))]
        (recur updated-grid updated-queue)))))

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
  (let [[height width grid] (read-input)]
    (-> (init-grid grid)
        (calculate-shortest-path [height width])
        (get-in [(dec height) (dec width)])
        (println))))
