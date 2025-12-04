(ns clojure-practice.paiza.prime-number-primer.is-prime-test
  (:require
   [clojure-practice.paiza.prime-number-primer.is-prime :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest is-prime
  (testing "sample1"
    (with-in-str "2"
      (let [actual (with-out-str (main))
            expected "YES\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "837"
      (let [actual (with-out-str (main))
            expected "NO\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "15"
      (let [actual (with-out-str (main))
            expected "NO\n"]
        (is (= expected actual)))))
  (testing "sample4"
    (with-in-str "2147483647"
      (let [actual (with-out-str (main))
            expected "YES\n"]
        (is (= expected actual))))))
