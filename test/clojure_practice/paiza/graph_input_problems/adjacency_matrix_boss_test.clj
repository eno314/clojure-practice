(ns clojure-practice.paiza.graph-input-problems.adjacency-matrix-boss-test
  (:require
   [clojure-practice.paiza.graph-input-problems.adjacency-matrix-boss :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest adjacency-matrix-boss-test
  (with-in-str "3 3\n0 1 0\n1 0 1\n0 1 0\n1 2\n1 3\n2 3\n"
    (let [actual (with-out-str (main))
          expected "1\n0\n1\n"]
      (is (= expected actual))))
  (with-in-str (str "5 10\n"
                    "0 1 1 0 0\n"
                    "1 0 0 1 1\n"
                    "1 0 0 0 0\n"
                    "0 1 0 0 1\n"
                    "0 1 0 1 0\n"
                    "1 2\n"
                    "1 3\n"
                    "1 4\n"
                    "1 5\n"
                    "2 3\n"
                    "4 2\n"
                    "5 2\n"
                    "4 3\n"
                    "5 3\n"
                    "5 4\n")
    (let [actual (with-out-str (main))
          expected "1\n1\n0\n0\n0\n1\n1\n0\n0\n1\n"]
      (is (= expected actual)))))
