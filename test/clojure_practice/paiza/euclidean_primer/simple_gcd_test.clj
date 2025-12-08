(ns clojure-practice.paiza.euclidean-primer.simple-gcd-test
  (:require
   [clojure-practice.paiza.euclidean-primer.simple-gcd :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest simple-gcd
  (testing "sample1"
    (with-in-str "45 15"
      (let [actual (with-out-str (main))
            expected "15\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "2 7"
      (let [actual (with-out-str (main))
            expected "1\n"]
        (is (= expected actual))))))
