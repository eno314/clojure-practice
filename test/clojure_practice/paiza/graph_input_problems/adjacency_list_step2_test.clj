(ns clojure-practice.paiza.graph-input-problems.adjacency-list-step2-test
  (:require
   [clojure-practice.paiza.graph-input-problems.adjacency-list-step2 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest adjacency-list-step2-test
  (with-in-str "3 2\n1 2\n2 3\n"
    (let [actual (with-out-str (main))
          expected "2\n3\n-1\n"]
      (is (= expected actual))))
  (with-in-str "5 5\n1 2\n1 3\n2 4\n4 5\n5 2\n"
    (let [actual (with-out-str (main))
          expected "2 3\n4\n-1\n5\n2\n"]
      (is (= expected actual)))))
