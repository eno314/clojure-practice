(ns clojure-practice.paiza.grid-dijkstra.d2-test
  (:require
   [clojure-practice.paiza.grid-dijkstra.d2 :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest d2
  (testing "入力例"
    (with-in-str "3 6\n0 3 1 4 1 5\n9 2 6 5 3 5\n3 9 7 9 3 2\n"
      (let [actual (with-out-str (main))
            expected "17\n"]
        (is (= actual expected))))))
