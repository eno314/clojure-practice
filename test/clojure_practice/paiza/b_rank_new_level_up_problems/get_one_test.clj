(ns clojure-practice.paiza.b-rank-new-level-up-problems.get-one-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.get-one :refer [read-input-borad]]
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
    (with-in-str "3 3\n...\n...\n...\n"
      (is (= (read-input-borad) (input-borad1)))))
  (testing "sample2"
    (with-in-str "4 4\n####\n####\n....\n##..\n"
      (is (= (read-input-borad) (input-borad2))))))