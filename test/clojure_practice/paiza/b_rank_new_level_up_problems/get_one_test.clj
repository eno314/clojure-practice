(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-one-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.get-one :refer [board-row-to-line read-input-borad update-borad]]
            [clojure.test :refer [deftest is testing]]))

(defn input-borad1 []
  [[false, false, false]
   [false, false, false]
   [false, false, false]])

(defn input-borad2 []
  [[true, true, true, true]
   [true, true, true, true]
   [false, false, false, false],
   [true, true, false, false]])

(deftest read-input-borad-test
  (testing "sample1"
    (with-in-str "...\n...\n...\n"
      (is (= (read-input-borad 3) (input-borad1)))))
  (testing "sample2"
    (with-in-str "####\n####\n....\n##..\n"
      (is (= (read-input-borad 4) (input-borad2))))))

(deftest update-borad-test
  (testing "sample1"
    (let [borad (input-borad1)]
      (is (= (update-borad borad 0 0)
             [[true, false, false]
              [false, false, false]
              [false, false, false]]))))
  (testing "sample2"
    (let [borad (input-borad2)]
      (is (= (update-borad borad 1 1)
             [[true, true, true, true]
              [true, false, true, true]
              [false, false, false, false],
              [true, true, false, false]])))))

(deftest board-row-to-line-test
  (is (= (board-row-to-line [true, false, false]) "#..")))