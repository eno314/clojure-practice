(ns clojure-practice.paiza.dp-primer.partial-sums-step0-test
  (:require
   [clojure-practice.paiza.dp-primer.partial-sums-step0 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest partial-sums-step0-test
  (with-in-str "3 10\n1\n2\n3\n"
    (let [actual (with-out-str (main))
          expected "no\n"]
      (is (= expected actual))))
  (with-in-str "5 19\n7\n18\n5\n4\n8\n"
    (let [actual (with-out-str (main))
          expected "yes\n"]
      (is (= expected actual)))))
