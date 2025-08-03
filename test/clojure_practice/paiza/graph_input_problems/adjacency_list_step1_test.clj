(ns clojure-practice.paiza.graph-input-problems.adjacency-list-step1-test
  (:require
   [clojure-practice.paiza.graph-input-problems.adjacency-list-step1 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest adjacency-list-step1-test
  (with-in-str "3 2\n1 2\n2 3\n"
    (let [actual (with-out-str (main))
          expected "2\n1 3\n2\n"]
      (is (= expected actual))))
  (with-in-str "5 5\n1 2\n1 3\n2 4\n2 5\n4 5\n"
    (let [actual (with-out-str (main))
          expected "2 3\n1 4 5\n1\n2 5\n2 4\n"]
      (is (= expected actual))))
  (with-in-str "5 1\n1 2\n"
    (let [actual (with-out-str (main))
          expected "2\n1\n-1\n-1\n-1\n"]
      (is (= expected actual)))))
