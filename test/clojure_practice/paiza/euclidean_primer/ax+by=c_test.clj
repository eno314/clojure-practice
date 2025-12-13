(ns clojure-practice.paiza.euclidean-primer.ax+by=c-test
  (:require
   [clojure-practice.paiza.euclidean-primer.ax+by=c :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest ax+by=c
  (testing "sample1"
    (with-in-str "15 100 10"
      (let [actual (with-out-str (main))
            expected "-6 1\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "8373 24 21"
      (let [actual (with-out-str (main))
            expected "1 -348\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "3 1048 1"
      (let [actual (with-out-str (main))
            expected "-349 1\n"]
        (is (= expected actual))))))
