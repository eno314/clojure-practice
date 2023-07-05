(ns clojure-practice.paiza.b-rank-new-level-up-problems.repeated-side-jump-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.repeated-side-jump :refer [calc-extra-moved count-left-jump
                                                                                            count-pass-between-left-and-center]]
            [clojure.test :refer [deftest is]]))

(deftest count-left-jump-test
  (is (= (count-left-jump 0) 0))
  (is (= (count-left-jump 1) 0))
  (is (= (count-left-jump 2) 0))
  (is (= (count-left-jump 3) 1))
  (is (= (count-left-jump 4) 1))
  (is (= (count-left-jump 5) 1))
  (is (= (count-left-jump 6) 1))
  (is (= (count-left-jump 7) 2))
  (is (= (count-left-jump 8) 2))
  (is (= (count-left-jump 9) 2))
  (is (= (count-left-jump 10) 2))
  (is (= (count-left-jump 11) 3))
  (is (= (count-left-jump 12) 3))
  (is (= (count-left-jump 13) 3))
  (is (= (count-left-jump 14) 3))
  (is (= (count-left-jump 15) 4))
  (is (= (count-left-jump 16) 4)))

(deftest count-pass-between-left-and-center-test
  (is (= (count-pass-between-left-and-center 3) 1))
  (is (= (count-pass-between-left-and-center 4) 2))
  (is (= (count-pass-between-left-and-center 6) 2))
  (is (= (count-pass-between-left-and-center 7) 3))
  (is (= (count-pass-between-left-and-center 8) 4))
  (is (= (count-pass-between-left-and-center 10) 4))
  (is (= (count-pass-between-left-and-center 11) 5))
  (is (= (count-pass-between-left-and-center 12) 6)))


(deftest calc-extra-moved-test
  (is (= (calc-extra-moved 1 3 10) 6))
  (is (= (calc-extra-moved 2 5 20) 30)))
