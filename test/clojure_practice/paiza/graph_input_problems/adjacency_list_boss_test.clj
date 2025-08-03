(ns clojure-practice.paiza.graph-input-problems.adjacency-list-boss-test
  (:require
   [clojure-practice.paiza.graph-input-problems.adjacency-list-boss :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest adjacency-list-boss-test
  (with-in-str "3 2\n1 2 1\n2 3 2\n"
    (let [actual (with-out-str (main))
          expected "1\n2\n-1\n"]
      (is (= expected actual))))
  (with-in-str "5 5\n1 2 30\n1 3 20\n2 4 10\n4 5 25\n5 2 5\n"
    (let [actual (with-out-str (main))
          expected "30 20\n10\n-1\n25\n5\n"]
      (is (= expected actual)))))
