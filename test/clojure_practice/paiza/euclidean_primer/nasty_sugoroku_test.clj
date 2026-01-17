(ns clojure-practice.paiza.euclidean-primer.nasty-sugoroku-test
  (:require
   [clojure-practice.paiza.euclidean-primer.nasty-sugoroku :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest nasty-sugoroku
  (testing "sample1"
    (with-in-str "12345 5\n"
      (let [actual (with-out-str (main))
            expected "-1\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "777 123\n"
      (let [actual (with-out-str (main))
            expected-count 90]
        (is (= expected-count (count actual)))))))
