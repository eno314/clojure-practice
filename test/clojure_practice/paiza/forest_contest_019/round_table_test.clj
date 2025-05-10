(ns clojure-practice.paiza.forest-contest-019.round-table-test
  (:require
   [clojure-practice.paiza.forest-contest-019.round-table :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest round-table-test
  (testing "入力例1"
    (with-in-str "5 3"
      (is (= "3\n" (with-out-str (main))))))

  (testing "入力例2"
    (with-in-str "5 8"
      (is (= "3\n" (with-out-str (main))))))

  (testing "入力例3"
    (with-in-str "7 8"
      (is (= "1\n" (with-out-str (main))))))

  (testing "入力例4"
    (with-in-str "2 2"
      (is (= "2\n" (with-out-str (main))))))

  (testing "入力例5"
    (with-in-str "1 10"
      (is (= "1\n" (with-out-str (main)))))))
