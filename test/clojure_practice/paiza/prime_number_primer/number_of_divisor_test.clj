(ns clojure-practice.paiza.prime-number-primer.number-of-divisor-test
  (:require
   [clojure-practice.paiza.prime-number-primer.number-of-divisor :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest number-of-divisor
  (testing "sample1"
    (with-in-str "8"
      (let [actual (with-out-str (main))
            expected "4\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "15"
      (let [actual (with-out-str (main))
            expected "4\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "100"
      (let [actual (with-out-str (main))
            expected "9\n"]
        (is (= expected actual)))))
  (testing "sample4"
    (with-in-str "174"
      (let [actual (with-out-str (main))
            expected "8\n"]
        (is (= expected actual))))))
