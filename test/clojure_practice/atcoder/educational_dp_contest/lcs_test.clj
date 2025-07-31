(ns clojure-practice.atcoder.educational-dp-contest.lcs-test
  (:require
   [clojure-practice.atcoder.educational-dp-contest.lcs :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest lcs-test
  (with-in-str "axyb\nabyxb\n"
    (let [actual (with-out-str (main))
          expected "ayb\n"]
      (is (= expected actual))))
  (with-in-str "aa\nxayaz\n"
    (let [actual (with-out-str (main))
          expected "aa\n"]
      (is (= expected actual))))
  (with-in-str "a\nz\n"
    (let [actual (with-out-str (main))
          expected "\n"]
      (is (= expected actual))))
  (with-in-str "abracadabra\navadakedavra\n"
    (let [actual (with-out-str (main))
          expected "aaadara\n"]
      (is (= expected actual)))))
