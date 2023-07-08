(ns clojure-practice.paiza.a-rank-level-up-problems.snake-map-step1-test
  (:require [clojure-practice.paiza.a-rank-level-up-problems.snake-map-step1 :refer [get-values-of-points]]
            [clojure.test :refer [deftest is]]))

(def board1 [[true true true]
             [true true true]
             [false false false]])

(def board2 [[true false]
             [false true]])

(deftest get-values-of-points-test
  (is (= (get-values-of-points board1 [[2 2] [1 1]]) [false true]))
  (is (= (get-values-of-points board2 [[0 1]]) [false])))
