(ns clojure-practice.paiza.b-rank-new-level-up-problems.board-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.board :refer [board-row-to-line read-input-board update-board]]
            [clojure.test :refer [deftest is testing]]))

(defn input-board1 []
  [[false false false]
   [false false false]
   [false false false]])

(defn input-board2 []
  [[true true true true]
   [true true true true]
   [false false false false]
   [true true false false]])

(defn input-board3 []
  [[true false]
   [true false]
   [true false]])

(deftest read-input-board-test
  (testing "sample1"
    (with-in-str "...\n...\n...\n"
      (is (= (read-input-board 3) (input-board1)))))
  (testing "sample2"
    (with-in-str "####\n####\n....\n##..\n"
      (is (= (read-input-board 4) (input-board2))))))

(deftest update-board-test
  (testing "sample1"
    (let [board (input-board1)]
      (is (= (update-board board 0 0)
             [[true false false]
              [false false false]
              [false false false]]))))
  (testing "sample2"
    (let [board (input-board2)]
      (is (= (update-board board 1 1)
             [[true true true true]
              [true false true true]
              [false false false false]
              [true true false false]]))))
  (testing "sample3"
    (let [board (input-board3)]
      (is (= (update-board board 0 0)
             [[false false]
              [true false]
              [true false]]))
      (is (= (update-board board 1 1)
             [[true false]
              [true true]
              [true false]]))
      (is (= (update-board board 2 1)
             [[true false]
              [true false]
              [true false]]))
      (is (= (update-board board 0 1)
             [[true false]
              [false false]
              [true false]]))
      (is (= (update-board board 1 0)
             [[true true]
              [true false]
              [true false]]))
      (is (= (update-board board 1 2)
             [[true false]
              [true false]
              [true true]])))))

(deftest board-row-to-line-test
  (is (= (board-row-to-line [true, false, false]) "#..")))
