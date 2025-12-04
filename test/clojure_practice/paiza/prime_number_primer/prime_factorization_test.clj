(ns clojure-practice.paiza.prime-number-primer.prime-factorization-test
  (:require
   [clojure-practice.paiza.prime-number-primer.prime-factorization :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest prime-factorization
  (testing "sample1"
    (with-in-str "8"
      (let [actual (with-out-str (main))
            expected "2\n2\n2\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "174"
      (let [actual (with-out-str (main))
            expected "2\n3\n29\n"]
        (is (= expected actual))))))
