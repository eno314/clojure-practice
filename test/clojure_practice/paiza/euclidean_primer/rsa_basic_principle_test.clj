(ns clojure-practice.paiza.euclidean-primer.rsa-basic-principle-test
  (:require
   [clojure-practice.paiza.euclidean-primer.rsa-basic-principle :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest rsa-basic-principle
  (testing "sample1"
    (with-in-str "63113 63311 3007 248429\n"
      (let [actual (with-out-str (main))
            expected "866360063\n189953047\n248429\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "19463 19469 2633 488357\n"
      (let [actual (with-out-str (main))
            expected "193256433\n322340256\n488357\n"]
        (is (= expected actual))))))
