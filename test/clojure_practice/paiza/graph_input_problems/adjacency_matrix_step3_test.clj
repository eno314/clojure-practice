(ns clojure-practice.paiza.graph-input-problems.adjacency-matrix-step3-test
  (:require
   [clojure-practice.paiza.graph-input-problems.adjacency-matrix-step3 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest adjacency-matrix-step3-test
  (with-in-str "3\n0 1 0\n1 0 1\n0 1 0\n"
    (let [actual (with-out-str (main))
          expected "2\n"]
      (is (= expected actual))))
  (with-in-str "5\n0 1 1 0 0\n1 0 0 1 1\n1 0 0 0 0\n0 1 0 0 1\n0 1 0 1 0\n"
    (let [actual (with-out-str (main))
          expected "5\n"]
      (is (= expected actual)))))
