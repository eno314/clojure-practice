(ns clojure-practice.paiza.dp-primer.stairs-step0-test
  (:require
   [clojure-practice.paiza.dp-primer.stairs-step0 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest stairs-step0-test
  (with-in-str "3\n"
    (let [actual (with-out-str (main))
          expected "3\n"]
      (is (= expected actual))))
  (with-in-str "4\n"
    (let [actual (with-out-str (main))
          expected "5\n"]
      (is (= expected actual))))
  (with-in-str "5\n"
    (let [actual (with-out-str (main))
          expected "8\n"]
      (is (= expected actual))))
  (with-in-str "6\n"
    (let [actual (with-out-str (main))
          expected "13\n"]
      (is (= expected actual)))))
