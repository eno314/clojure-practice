(ns clojure-practice.paiza.b-rank-new-level-up-problems.move-simulation
  (:require [clojure-practice.paiza.libs :refer [read-int-value-line
                                                 read-int-values-lines]]))

(defn load-data []
  (let [n (read-int-value-line)
        time-and-locs (read-int-values-lines n)]
    (vec (map (fn [[time x y]] {:time time :loc [x y]}) time-and-locs))))

(defn past-data
  "指定した時間以前のデータを取得します。"
  [dataset time]
  (first (filter #(<= (:time %) time) (reverse dataset))))

(defn future-data
  "指定した時間以降のデータを取得します。"
  [dataset time]
  (first (filter #(>= (:time %) time) dataset)))

(defn exact-time-data
  "指定した時間の正確なデータが存在する場合はそのデータを返し、存在しない場合はnilを返します。"
  [dataset time]
  (first (filter #(= (:time %) time) dataset)))

(defn interpolate-loc
  "2つの位置と時間に基づき、指定した時間の位置を補間します。"
  [past future time]
  (let [ratio (/ (- time (:time past)) (- (:time future) (:time past)))]
    (mapv (fn [p f] (Math/round (double (+ (* (- f p) ratio) p))))
          (:loc past) (:loc future))))

(defn interpolate
  "指定された時間におけるユーザーの位置を補間します。
   指定された時間がデータセットの時刻に正確に一致する場合、その位置がそのまま返されます。
   一致しない場合、過去と未来の位置を元に位置を補間します。"
  [dataset time]
  (let [exact (exact-time-data dataset time)
        past (past-data dataset time)
        future (future-data dataset time)]
    (cond
      exact (:loc exact)
      (and past future) (interpolate-loc past future time)
      :else nil)))

(defn move-simulation
  [dataset]
  (let [first-time (:time (first dataset))
        last-time (:time (last dataset))]
    (vec (map (fn [time] (interpolate dataset time))
              (range first-time (inc last-time))))))

(defn main
  []
  (let [dataset (load-data)]
    (doseq [loc (move-simulation dataset)]
      (println (str (first loc) " " (second loc))))))

; (main)
