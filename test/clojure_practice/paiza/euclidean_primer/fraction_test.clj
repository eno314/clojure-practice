(ns clojure-practice.paiza.euclidean-primer.fraction-test
  (:require
   [clojure-practice.paiza.euclidean-primer.fraction :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest fraction
  (testing "sample1"
    (with-in-str "1 2 + 1 5\n"
      (let [actual (with-out-str (main))
            expected "7 10\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "2 3 * -9 2\n"
      (let [actual (with-out-str (main))
            expected "-3 1\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "-2 3 / -9 2\n"
      (let [actual (with-out-str (main))
            expected "4 27\n"]
        (is (= expected actual))))))
