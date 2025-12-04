(ns clojure-practice.paiza.prime-number-primer.least-common-multiple-test
  (:require
   [clojure-practice.paiza.prime-number-primer.least-common-multiple :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest least-common-multiple
  (testing "sample1"
    (with-in-str "3\n12\n30\n81"
      (let [actual (with-out-str (main))
            expected "1620\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "2\n10\n25"
      (let [actual (with-out-str (main))
            expected "50\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "4\n2\n3\n5\n7"
      (let [actual (with-out-str (main))
            expected "210\n"]
        (is (= expected actual))))))
