(ns clojure-practice.paiza.euclidean-primer.mod-inverse-test
  (:require
   [clojure-practice.paiza.euclidean-primer.mod-inverse :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest mod-inverse
  (testing "sample1"
    (with-in-str "7 11\n"
      (let [actual (with-out-str (main))
            expected "2\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "123 56\n"
      (let [actual (with-out-str (main))
            expected "11\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "2 7\n"
      (let [actual (with-out-str (main))
            expected "1\n"]
        (is (= expected actual))))))
