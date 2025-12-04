(ns clojure-practice.paiza.prime-number-primer.greatest-common-divisor-test
  (:require
   [clojure-practice.paiza.prime-number-primer.greatest-common-divisor :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest greatest-common-divisor
  (testing "sample1"
    (with-in-str "2\n6\n8"
      (let [actual (with-out-str (main))
            expected "2\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "4\n7\n14\n35\n60"
      (let [actual (with-out-str (main))
            expected "1\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "3\n9\n27\n81"
      (let [actual (with-out-str (main))
            expected "9\n"]
        (is (= expected actual)))))
  (testing "sample4"
    (with-in-str "10\n2\n3\n5\n7\n11\n13\n17\n19\n23\n29"
      (let [actual (with-out-str (main))
            expected "1\n"]
        (is (= expected actual))))))
