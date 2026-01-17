(ns clojure-practice.paiza.euclidean-primer.rsa-solve-string-test
  (:require
   [clojure-practice.paiza.euclidean-primer.rsa-solve-string :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest rsa-basic-solve-string
  (testing "sample1"
    (with-in-str "3995747143 3007 602607029\n"
      (let [actual (with-out-str (main))
            expected "PAIZ\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "378925147 2633 253439504\n"
      (let [actual (with-out-str (main))
            expected "Nice\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "9998000099 65537 6337020097\n"
      (let [actual (with-out-str (main))
            expected "WOW!\n"]
        (is (= expected actual))))))
