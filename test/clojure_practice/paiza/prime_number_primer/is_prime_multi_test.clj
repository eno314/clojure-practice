(ns clojure-practice.paiza.prime-number-primer.is-prime-multi-test
  (:require
   [clojure-practice.paiza.prime-number-primer.is-prime-multi :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest is-prime
  (testing "sample1"
    (with-in-str "5\n5\n6\n7\n8\n9"
      (let [actual (with-out-str (main))
            expected "pass\nfailure\npass\nfailure\nfailure\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "15\n1066\n9116\n4350\n8707\n99614\n48979\n51412\n26894\n11779\n3082\n96436\n43526\n45530\n6694\n71442"
      (let [actual (with-out-str (main))
            expected "failure\nfailure\nfailure\npass\nfailure\nfailure\nfailure\nfailure\npass\nfailure\nfailure\nfailure\nfailure\nfailure\nfailure\n"]
        (is (= expected actual))))))
