(ns clojure-practice.atcoder.educational-dp-contest.vacation-test
  (:require
   [clojure-practice.atcoder.educational-dp-contest.vacation :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest vacation-test
  (with-in-str "3\n10 40 70\n20 50 80\n30 60 90\n"
    (let [actual (with-out-str (main))
          expected "210\n"]
      (is (= expected actual))))
  (with-in-str "1\n100 10 1\n"
    (let [actual (with-out-str (main))
          expected "100\n"]
      (is (= expected actual))))
  (with-in-str "7\n6 7 8\n8 8 3\n2 5 2\n7 8 6\n4 6 8\n2 3 4\n7 5 1\n"
    (let [actual (with-out-str (main))
          expected "46\n"]
      (is (= expected actual)))))
