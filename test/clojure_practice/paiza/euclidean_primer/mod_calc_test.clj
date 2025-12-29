(ns clojure-practice.paiza.euclidean-primer.mod-calc-test
  (:require
   [clojure-practice.paiza.euclidean-primer.mod-calc :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest mod-calc
  (testing "sample1"
    (with-in-str "17\n56 + 927\n"
      (let [actual (with-out-str (main))
            expected "14\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "837\n9282 * 10384\n"
      (let [actual (with-out-str (main))
            expected "390\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "99999\n100000 ^ 100000\n"
      (let [actual (with-out-str (main))
            expected "1\n"]
        (is (= expected actual))))))
