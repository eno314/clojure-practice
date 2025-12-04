(ns clojure-practice.paiza.prime-number-primer.chinese-remainder-theorem-test
  (:require
   [clojure-practice.paiza.prime-number-primer.chinese-remainder-theorem :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest chinese-remainder-theorem
  (testing "sample1"
    (with-in-str "5 6 2 3"
      (let [actual (with-out-str (main))
            expected "27\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "100 101 10 11"
      (let [actual (with-out-str (main))
            expected "10010\n"]
        (is (= expected actual))))))
