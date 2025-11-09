(ns clojure-practice.paiza.prime-number-primer.goldbach-conjecture-test
  (:require
   [clojure-practice.paiza.prime-number-primer.goldbach-conjecture :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest goldbach-conjecture
  (testing "sample1"
    (with-in-str "4\n"
      (let [actual (with-out-str (main))
            expected "2\n2\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "98476\n"
      (let [actual (with-out-str (main))
            expected "49223\n49253\n"]
        (is (= expected actual)))))
  (testing "sample3"
    (with-in-str "108\n"
      (let [actual (with-out-str (main))
            expected "47\n61\n"]
        (is (= expected actual))))))

