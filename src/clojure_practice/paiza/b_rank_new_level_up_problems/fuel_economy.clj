(ns clojure-practice.paiza.b-rank-new-level-up-problems.fuel-economy
  (:require [clojure-practice.paiza.libs :refer [read-int-value-line
                                                 read-int-values-line]]))

(defn read-input []
  (let [x (read-int-value-line)
        [starting running] (read-int-values-line)
        [total_distance] (read-int-values-line)
        stop_points (read-int-values-line)]
    {:economy {:change_distance x
               :starting starting
               :running running}
     :total_distance total_distance
     :stop_points stop_points}))

(defn create-moving-distances [total_distance stop_points]
  ; "停止地点リストの最後尾にtotal_distanceを追加したリスト"と"停止地点リストの先頭に0を追加したリスト"のお互いの要素を引いたリストを作成する
  ; [30 60 100]
  ; [0 30 60]
  ; ↓
  ; [30 30 40]
  (vec (map #(- %1 %2) (conj stop_points total_distance) (cons 0 stop_points))))

(defn calc-fuel [economy, moving_distance]
  (if (<= moving_distance (:change_distance economy))
    ; 消費燃料の切り替え距離を超えていない場合
    (* moving_distance (:starting economy))
    ; 消費燃料の切り替え距離を超えた場合
    (let [starting-fuel (* (:change_distance economy) (:starting economy))
          running-fuel (* (- moving_distance (:change_distance economy)) (:running economy))]
      (+ starting-fuel running-fuel))))

(defn calc-total-fuel [input]
  ; 総移動距離と停止地点リストから、移動距離リストを作成する
  (let [moving_distances (create-moving-distances (:total_distance input) (:stop_points input))]
    ; reduceと移動距離から必要燃料量を計算する関数を使って、合計の必要な燃料量を求める
    (reduce (fn [total-fuel moving_distance]
              (+ total-fuel (calc-fuel (:economy input) moving_distance)))
            0 moving_distances)))

(defn main []
  (println (calc-total-fuel (read-input))))
