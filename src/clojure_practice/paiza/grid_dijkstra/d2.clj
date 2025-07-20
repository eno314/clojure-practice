(ns clojure-practice.paiza.grid-dijkstra.d2
  (:require
   [clojure-practice.paiza.libs :refer [read-int-values-line
                                        read-int-values-lines]]))

;; 入力データを読み込み、グリッドの高さ・幅・マップデータを取得
(defn- read-input []
  (let [[height width] (read-int-values-line)]
    [height width (read-int-values-lines height)]))

;; グリッドのポイントを初期化（最適化版）
(defn- init-grid-point [row col cost]
  {:position [row col]
   :cost cost
   :total-cost (if (and (zero? row) (zero? col)) cost Long/MAX_VALUE)
   :visited? false})

;; グリッドを初期化（最適化版）
(defn- init-grid [input-grid]
  (let [height (count input-grid)
        width (count (first input-grid))]
    (vec (for [row (range height)]
           (vec (for [col (range width)]
                  (init-grid-point row col (get-in input-grid [row col]))))))))

;; 指定された位置の上下左右の隣接位置を取得（最適化版）
(defn- neighbors [[row col] [height width]]
  (let [candidates [[(inc row) col] [row (inc col)] [(dec row) col] [row (dec col)]]
        [h w] [height width]]
    (filter (fn [[r c]]
              (and (>= r 0) (< r h) (>= c 0) (< c w)))
            candidates)))

;; JavaのPriorityQueueを使用した効率的な優先度付きキュー
(defn- create-priority-queue []
  (java.util.PriorityQueue.
   (comparator (fn [a b]
                 (if (= (:total-cost a) (:total-cost b))
                   (< (hash (:position a)) (hash (:position b)))
                   (< (:total-cost a) (:total-cost b)))))))

;; 優先度付きキューに要素を追加（Java PriorityQueue版）
(defn- enqueue [queue item]
  (.offer queue item)
  queue)

;; 優先度付きキューから最小要素を取り出す（Java PriorityQueue版）
(defn- dequeue [queue]
  (let [item (.poll queue)]
    [item queue]))

;; 指定された位置の上下左右の隣接位置を訪問して、合計コストを更新（Java PriorityQueue版）
(defn- visit-neighbors [grid current-point height-width queue]
  (let [current-total-cost (:total-cost current-point)
        neighbor-positions (neighbors (:position current-point) height-width)]
    (reduce (fn [[updated-grid updated-queue] neighbor-pos]
              (let [neighbor-point (get-in updated-grid neighbor-pos)]
                (if (and (not (:visited? neighbor-point))
                         (< (+ current-total-cost (:cost neighbor-point))
                            (:total-cost neighbor-point)))
                  (let [new-total-cost (+ current-total-cost (:cost neighbor-point))
                        updated-neighbor-point (assoc neighbor-point
                                                      :total-cost
                                                      new-total-cost)
                        updated-grid-with-neighbor (assoc-in updated-grid
                                                             neighbor-pos
                                                             updated-neighbor-point)
                        enqueued-queue (enqueue updated-queue
                                                updated-neighbor-point)]
                    [updated-grid-with-neighbor enqueued-queue])
                  [updated-grid updated-queue])))
            [grid queue]
            neighbor-positions)))

;; ダイクストラ法で最短経路のコストを計算（Java PriorityQueue版）
(defn- calculate-shortest-cost [grid height-width]
  (loop [grid grid
         queue (enqueue (create-priority-queue) (get-in grid [0 0]))]
    (let [[current-point remaining-queue] (dequeue queue)]
      (if (nil? current-point)
        grid
        (if (:visited? current-point)
          (recur grid remaining-queue)
          (let [visited-grid (assoc-in grid (:position current-point)
                                       (assoc current-point :visited? true))
                [updated-grid updated-queue] (visit-neighbors visited-grid
                                                              current-point
                                                              height-width
                                                              remaining-queue)]
            (recur updated-grid updated-queue)))))))


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
