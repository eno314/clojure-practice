(ns clojure-practice.paiza.euclidean-primer.multi-gcd-test
  (:require
   [clojure-practice.paiza.euclidean-primer.multi-gcd :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest multi-gcd
  (testing "sample1"
    (with-in-str "3\n6\n18\n30"
      (let [actual (with-out-str (main))
            expected "6\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "5\n7\n10\n30\n55\n175"
      (let [actual (with-out-str (main))
            expected "1\n"]
        (is (= expected actual))))))
