(ns clojure-practice.paiza.b-rank-new-level-up-problems.perfect-shuffle-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.perfect-shuffle :refer [initail-cards shuffle-cards shuffle-cards-repeatedly]]
            [clojure.test :refer [deftest is]]))

(deftest initial-cards-test
  (is (= (initail-cards)
         ["S_1" "S_2" "S_3" "S_4" "S_5" "S_6" "S_7" "S_8" "S_9" "S_10" "S_11" "S_12" "S_13"
          "H_1" "H_2" "H_3" "H_4" "H_5" "H_6" "H_7" "H_8" "H_9" "H_10" "H_11" "H_12" "H_13"
          "D_1" "D_2" "D_3" "D_4" "D_5" "D_6" "D_7" "D_8" "D_9" "D_10" "D_11" "D_12" "D_13"
          "C_1" "C_2" "C_3" "C_4" "C_5" "C_6" "C_7" "C_8" "C_9" "C_10" "C_11" "C_12" "C_13"])))

(deftest shuffle-cards-test
  (is (= (shuffle-cards (initail-cards))
         ["S_1" "D_1" "S_2" "D_2" "S_3" "D_3" "S_4" "D_4" "S_5" "D_5" "S_6" "D_6" "S_7"
          "D_7" "S_8" "D_8" "S_9" "D_9" "S_10" "D_10" "S_11" "D_11" "S_12" "D_12" "S_13" "D_13"
          "H_1" "C_1" "H_2" "C_2" "H_3" "C_3" "H_4" "C_4" "H_5" "C_5" "H_6" "C_6" "H_7"
          "C_7" "H_8" "C_8" "H_9" "C_9" "H_10" "C_10" "H_11" "C_11" "H_12" "C_12" "H_13" "C_13"])))

(deftest shuffle-cards-repeatedly-test
  (is (= (shuffle-cards-repeatedly (initail-cards) 1)
         ["S_1" "D_1" "S_2" "D_2" "S_3" "D_3" "S_4" "D_4" "S_5" "D_5" "S_6" "D_6" "S_7"
          "D_7" "S_8" "D_8" "S_9" "D_9" "S_10" "D_10" "S_11" "D_11" "S_12" "D_12" "S_13" "D_13"
          "H_1" "C_1" "H_2" "C_2" "H_3" "C_3" "H_4" "C_4" "H_5" "C_5" "H_6" "C_6" "H_7"
          "C_7" "H_8" "C_8" "H_9" "C_9" "H_10" "C_10" "H_11" "C_11" "H_12" "C_12" "H_13" "C_13"]))
  (is (= (shuffle-cards-repeatedly (initail-cards) 3)
         ["S_1" "D_7" "H_1" "C_7" "D_1" "S_8" "C_1" "H_8" "S_2" "D_8" "H_2" "C_8" "D_2"
          "S_9" "C_2" "H_9" "S_3" "D_9" "H_3" "C_9" "D_3" "S_10" "C_3" "H_10" "S_4" "D_10"
          "H_4" "C_10" "D_4" "S_11" "C_4" "H_11" "S_5" "D_11" "H_5" "C_11" "D_5" "S_12" "C_5"
          "H_12" "S_6" "D_12" "H_6" "C_12" "D_6" "S_13" "C_6" "H_13" "S_7" "D_13" "H_7" "C_13"])))
