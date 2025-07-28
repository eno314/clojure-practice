(ns clojure-practice.atcoder.educational-dp-contest.vacation
  (:require
   [clojure-practice.paiza.libs :refer [read-int-value-line
                                        read-int-values-lines]]))

(defn- max-happiness-dp-of-day [happiness-table dp day]
  (let [[a b c] (nth happiness-table (dec day))
        [a-last-dp b-last-dp c-last-dp] (last dp)]
    [(+ a (max b-last-dp c-last-dp))
     (+ b (max a-last-dp c-last-dp))
     (+ c (max a-last-dp b-last-dp))]))

(defn- calc-max-happiness [n happiness-table]
  (loop [day 1
         dp [[0 0 0]]]
    (if (< n day)
      dp
      (recur (inc day)
             (conj dp
                   (max-happiness-dp-of-day happiness-table dp day))))))

(defn- get-max-happiness-of-day [dp]
  (let [[max-a max-b max-c] (last dp)]
    (max max-a max-b max-c)))

(defn main
  "https://atcoder.jp/contests/dp/tasks/dp_c
   明日から太郎君の夏休みが始まります。 太郎君は夏休みの計画を立てることにしました。
   夏休みは N 日からなります。
   各 i (1≤i≤N) について、i 日目には太郎君は次の活動のうちひとつを選んで行います。
   ・A: 海で泳ぐ。 幸福度 ai を得る。
   ・B: 山で虫取りをする。 幸福度 bi を得る。
   ・C: 家で宿題をする。 幸福度 ci を得る。
   太郎君は飽き性なので、2 日以上連続で同じ活動を行うことはできません。
   太郎君が得る幸福度の総和の最大値を求めてください。
   [input]
   N
   a1 b1 c1
   a2 b2 c2
   ...
   aN bN cN
   [output]
   太郎君が得る幸福度の総和の最大値
   "
  []
  (let [n (read-int-value-line)
        happiness-table (read-int-values-lines n)]
    (-> (calc-max-happiness n happiness-table)
        (get-max-happiness-of-day)
        (println))))
