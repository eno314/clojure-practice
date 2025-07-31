(ns clojure-practice.paiza.graph-input-problems.adjacency-matrix-step1-test
  (:require
   [clojure-practice.paiza.graph-input-problems.adjacency-matrix-step1 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest adjacency-matrix-step1-test
  (with-in-str "3 2\n1 2\n2 3\n"
    (let [actual (with-out-str (main))
          expected "0 1 0\n1 0 1\n0 1 0\n"]
      (is (= expected actual))))
  (with-in-str "5 5\n1 2\n1 3\n2 4\n2 5\n4 5\n"
    (let [actual (with-out-str (main))
          expected "0 1 1 0 0\n1 0 0 1 1\n1 0 0 0 0\n0 1 0 0 1\n0 1 0 1 0\n"]
      (is (= expected actual)))))
