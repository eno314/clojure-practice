(ns clojure-practice.paiza.euclidean-primer.fast-exponentiation-test
  (:require
   [clojure-practice.paiza.euclidean-primer.fast-exponentiation :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest fast-exponentiation
  (testing "sample1"
    (with-in-str "2 5 7\n"
      (let [actual (with-out-str (main))
            expected "4\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "538 3875 28474\n"
      (let [actual (with-out-str (main))
            expected "13218\n"]
        (is (= expected actual))))))
