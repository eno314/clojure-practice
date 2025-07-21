(ns clojure-practice.paiza.dp-primer.apples-step1-test
  (:require
   [clojure-practice.paiza.dp-primer.apples-step1 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest apples-step1-test
  (with-in-str "1 110 200\n"
    (let [actual (with-out-str (main))
          expected "110\n"]
      (is (= expected actual))))
  (with-in-str "2 110 200\n"
    (let [actual (with-out-str (main))
          expected "110\n"]
      (is (= expected actual))))
  (with-in-str "3 110 200\n"
    (let [actual (with-out-str (main))
          expected "200\n"]
      (is (= expected actual))))
  (with-in-str "6 110 200\n"
    (let [actual (with-out-str (main))
          expected "310\n"]
      (is (= expected actual)))))
