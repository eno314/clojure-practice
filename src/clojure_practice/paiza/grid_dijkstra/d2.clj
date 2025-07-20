(ns clojure-practice.paiza.grid-dijkstra.d2
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]))

;; コストの最大値
(def MAX_TOAL_COST Integer/MAX_VALUE)

;; 入力データを読み込み、グリッドの高さ・幅・マップデータを取得
(defn- read-input []
  (let [[height width] (read-int-values-line)]
    [height width (read-int-values-lines height)]))

;; グリッドのポイントを初期化
(defn- init-grid-point [row col cost]
  {:position [row col]
   :cost cost
   :total-cost (if (and (zero? row) (zero? col)) cost MAX_TOAL_COST)
   :visited? false})


;; グリッドを初期化
;; - 位置情報,コスト,合計コスト(初期値はMAX_TOAL_COST),確定済みフラグを持つグリッドを作成
;; - スタート位置の合計コストだけは、コストの値を設定
(defn- init-grid [input-grid]
  (vec
   (map-indexed (fn [row cols]
                  (vec (map-indexed #(init-grid-point row %1 %2) cols)))
                input-grid)))

;; 指定された位置の上下左右の隣接位置を取得
(defn- neighbors [[row col] [height width]]
  (filter (fn [[r c]]
            (and (>= r 0) (< r height)
                 (>= c 0) (< c width)))
          [[(inc row) col] [row (inc col)] [(dec row) col] [row (dec col)]]))

;; 未訪問のポイントのうち、最小のtotal-costを持つポイントを見つける
(defn- find-min-unvisited [grid [height width]]
  (let [all-points (for [row (range height)
                         col (range width)]
                     (get-in grid [row col]))
        unvisited-points (filter #(not (:visited? %)) all-points)]
    (when (seq unvisited-points)
      (apply min-key :total-cost unvisited-points))))

;; 指定された位置の上下左右の隣接位置を訪問して、合計コストを更新
(defn- visit-neighbors [grid current-point height-width]
  (reduce (fn [updated-grid neighbor-pos]
            (let [neighbor-point (get-in updated-grid neighbor-pos)
                  new-total-cost (+ (:total-cost current-point)
                                    (:cost neighbor-point))]
              (if (and (not (:visited? neighbor-point))
                       (< new-total-cost (:total-cost neighbor-point)))
                (assoc-in updated-grid neighbor-pos
                          (assoc neighbor-point :total-cost new-total-cost))
                updated-grid)))
          grid
          (neighbors (:position current-point) height-width)))

;; ダイクストラ法で最短経路のコストを計算
(defn- calculate-shortest-cost [grid height-width]
  (loop [grid grid]
    (let [current-point (find-min-unvisited grid height-width)]
      (if (nil? current-point)
        grid
        (let [visited-grid (assoc-in grid (:position current-point)
                                     (assoc current-point :visited? true))
              updated-grid (visit-neighbors visited-grid current-point height-width)]
          (recur updated-grid))))))


(defn main
  "https://paiza.jp/works/mondai/grid_dijkstra/grid_dijkstra__d2
   グリッド状の盤面で上下左右の移動を繰り返して、
   左上のスタートから右下のゴールまで移動するときに
   通るマス (スタート、ゴール含む) のコストの合計の最小値を求めてください。
   ・ 1 行目には盤面の行数を表す h , 盤面の列数を表す w が与えられます。
   ・ 続く h 行のうち i 行目には、i 行目のマスのコストを表す整数値のリスト t_i が与えられます。
   ・ t_{i,j} は i 行目の j 列目のコストです。"
  []
  (let [[height width grid] (read-input)]
    (-> (init-grid grid)
        (calculate-shortest-cost [height width])
        (get-in [(dec height) (dec width)])
        (:total-cost)
        (println))))
