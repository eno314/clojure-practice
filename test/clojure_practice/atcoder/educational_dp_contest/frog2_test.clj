(ns clojure-practice.atcoder.educational-dp-contest.frog2-test
  (:require
   [clojure-practice.atcoder.educational-dp-contest.frog2 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest frog2-test
  (with-in-str "4 2\n10 30 40 20\n"
    (let [actual (with-out-str (main))
          expected "30\n"]
      (is (= expected actual))))
  (with-in-str "5 3\n10 30 40 50 20\n"
    (let [actual (with-out-str (main))
          expected "30\n"]
      (is (= expected actual))))
  (with-in-str "3 1\n10 20 10\n"
    (let [actual (with-out-str (main))
          expected "20\n"]
      (is (= expected actual))))
  (with-in-str "2 100\n10 10\n"
    (let [actual (with-out-str (main))
          expected "0\n"]
      (is (= expected actual))))
  (with-in-str "10 4\n40 10 20 70 80 10 20 70 80 60\n"
    (let [actual (with-out-str (main))
          expected "40\n"]
      (is (= expected actual)))))
