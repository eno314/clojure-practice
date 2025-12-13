(ns clojure-practice.paiza.euclidean-primer.extgcd-test

  (:require
   [clojure-practice.paiza.euclidean-primer.extgcd :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest extgcd
  (testing "sample1"
    (with-in-str "2944 3958\n"
      (let [actual (with-out-str (main))
            expected "-929 691\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "2 7\n"
      (let [actual (with-out-str (main))
            expected "-3 1\n"]
        (is (= expected actual))))))
