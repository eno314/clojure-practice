(ns clojure-practice.paiza.grid-dijkstra.d1-test
  (:require
   [clojure-practice.paiza.grid-dijkstra.d1 :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest d1
  (testing "入力例"
    (with-in-str "3 6\n0 0 1 0 0 0\n1 0 1 0 1 0\n0 0 0 0 1 0\n"
      (let [actual (with-out-str (main))
            expected "12\n"]
        (is (= expected actual))))))
