(ns clojure-practice.paiza.grid-dijkstra.d2-test
  (:require
   [clojure-practice.paiza.grid-dijkstra.d2 :refer [main]]
   [clojure.test :refer [deftest is testing]]))

;; グリッドデータを文字列に変換するヘルパー関数
(defn- grid-to-input [height width grid-data]
  (let [header (str height " " width "\n")
        rows (map #(clojure.string/join " " %) grid-data)]
    (str header (clojure.string/join "\n" rows) "\n")))

;; テスト用の入力データを定義
(def test-cases
  {:original-example
   {:height 3 :width 6
    :grid [[0 3 1 4 1 5]
           [9 2 6 5 3 5]
           [3 9 7 9 3 2]]
    :expected "17\n"}

   :grid-big-size
   {:height 250 :width 250
    :grid (vec (for [_ (range 250)]
                 (vec (for [_ (range 250)] 1))))
    :expected "499\n"}

   :grid-7x7-pattern
   {:height 7 :width 7
    :grid [[0 9 1 9 1 9 1]
           [9 1 9 1 9 1 9]
           [1 9 1 9 1 9 1]
           [9 1 9 1 9 1 9]
           [1 9 1 9 1 9 1]
           [9 1 9 1 9 1 9]
           [1 9 1 9 1 9 0]]
    :expected "59\n"}})

;; テストケースを実行するヘルパー関数
(defn- run-test-case [test-name test-case]
  (testing test-name
    (let [input (grid-to-input (:height test-case) (:width test-case) (:grid test-case))]
      (with-in-str input
        (let [actual (with-out-str (main))
              expected (:expected test-case)]
          (is (= actual expected)))))))

(deftest d2
  (run-test-case "入力例" (:original-example test-cases))
  (run-test-case "大きなグリッド" (:grid-big-size test-cases))
  (run-test-case "複雑なパターンのグリッド（7x7）" (:grid-7x7-pattern test-cases)))
