(ns clojure-practice.paiza.dp-primer.apples-step2-test
  (:require
   [clojure-practice.paiza.dp-primer.apples-step2 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest apples-step2-test
  (with-in-str "5 1 100 2 150\n"
    (let [actual (with-out-str (main))
          expected "400\n"]
      (is (= expected actual))))
  (with-in-str "6 2 110 5 200\n"
    (let [actual (with-out-str (main))
          expected "310\n"]
      (is (= expected actual))))
  (with-in-str "11 3 200 4 300\n"
    (let [actual (with-out-str (main))
          expected "800\n"]
      (is (= expected actual)))))
