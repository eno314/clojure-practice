(ns clojure-practice.paiza.grid-dijkstra.d0-test
  (:require
   [clojure-practice.paiza.grid-dijkstra.d0 :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest d0
  (testing "入力例"
    (with-in-str "2 5\n0 1 2 3 4\n5 6 7 8 9\n"
      (let [actual (with-out-str (main))
            expected "17\n"]
        (is (= expected actual))))))
