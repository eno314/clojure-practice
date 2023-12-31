(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-upsidedown-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.get-upsidedown :refer [update-board-all-point]]
            [clojure.test :refer [deftest is testing]]))

(defn input-board1 []
  [[false false false]
   [false false false]
   [false false false]])

(defn input-board2 []
  [[true false]
   [true false]
   [true false]])

(deftest update-board-all-point-test
  (testing "sample1"
    (is (= (update-board-all-point (input-board1) 1 1)
           [[false true false]
            [true true true]
            [false true false]]))
    (is (= (update-board-all-point (input-board1) 0 0)
           [[true true false]
            [true false false]
            [false false false]]))
    (is (= (update-board-all-point (input-board1) 2 2)
           [[false false false]
            [false false true]
            [false true true]])))
  (testing "sample2"
    (is (= (update-board-all-point (input-board2) 0 0)
           [[false true]
            [false false]
            [true false]]))
    (is (= (update-board-all-point (input-board2) 1 1)
           [[true true]
            [false true]
            [true true]]))))
