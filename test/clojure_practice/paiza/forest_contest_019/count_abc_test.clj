(ns clojure-practice.paiza.forest-contest-019.count-abc-test
  (:require
   [clojure-practice.paiza.forest-contest-019.count-abc :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest count-abc-test
  (testing "入力例1"
    (with-in-str "4\nC B A C"
      (let [actual (with-out-str (main))
            expected "1\n1\n2\n"]
        (is (= expected actual)))))

  (testing "入力例2"
    (with-in-str "5\nP A I Z A"
      (let [actual (with-out-str (main))
            expected "2\n0\n0\n"]
        (is (= expected actual))))))
