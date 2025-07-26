(ns clojure-practice.atcoder.educational-dp-contest.frog1-test
  (:require
   [clojure-practice.atcoder.educational-dp-contest.frog1 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest frog1-test
  (with-in-str "4\n10 30 40 20\n"
    (let [actual (with-out-str (main))
          expected "30\n"]
      (is (= expected actual))))
  (with-in-str "2\n10 10\n"
    (let [actual (with-out-str (main))
          expected "0\n"]
      (is (= expected actual))))
  (with-in-str "6\n30 10 60 10 60 50\n"
    (let [actual (with-out-str (main))
          expected "40\n"]
      (is (= expected actual)))))
