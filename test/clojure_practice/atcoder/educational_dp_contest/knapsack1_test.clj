(ns clojure-practice.atcoder.educational-dp-contest.knapsack1-test
  (:require
   [clojure-practice.atcoder.educational-dp-contest.knapsack1 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest knapsack1-test
  (with-in-str "3 8\n3 30\n4 50\n5 60\n"
    (let [actual (with-out-str (main))
          expected "90\n"]
      (is (= expected actual))))
  (with-in-str "5 5\n1 1000000000\n1 1000000000\n1 1000000000\n1 1000000000\n1 1000000000\n"
    (let [actual (with-out-str (main))
          expected "5000000000\n"]
      (is (= expected actual))))
  (with-in-str "6 15\n6 5\n5 6\n6 4\n6 6\n3 5\n7 2\n"
    (let [actual (with-out-str (main))
          expected "17\n"]
      (is (= expected actual)))))
