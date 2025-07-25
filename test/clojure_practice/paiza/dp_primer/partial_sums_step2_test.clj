(ns clojure-practice.paiza.dp-primer.partial-sums-step2-test
  (:require
   [clojure-practice.paiza.dp-primer.partial-sums-step2 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest partial-sums-step2-test
  (with-in-str "3 10\n1\n2\n3\n"
    (let [actual (with-out-str (main))
          expected "-1\n"]
      (is (= expected actual))))
  (with-in-str "5 10\n7\n3\n4\n3\n2\n"
    (let [actual (with-out-str (main))
          expected "2\n"]
      (is (= expected actual))))
  (with-in-str "3 3\n1\n1\n2\n"
    (let [actual (with-out-str (main))
          expected "2\n"]
      (is (= expected actual)))))
