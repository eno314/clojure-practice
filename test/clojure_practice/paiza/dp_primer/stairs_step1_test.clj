(ns clojure-practice.paiza.dp-primer.stairs-step1-test
  (:require
   [clojure-practice.paiza.dp-primer.stairs-step1 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest stairs-step1-test
  (with-in-str "4 1 2\n"
    (let [actual (with-out-str (main))
          expected "5\n"]
      (is (= expected actual))))
  (with-in-str "4 1 2\n"
    (let [actual (with-out-str (main))
          expected "5\n"]
      (is (= expected actual))))
  (with-in-str "4 3 5\n"
    (let [actual (with-out-str (main))
          expected "0\n"]
      (is (= expected actual)))))
