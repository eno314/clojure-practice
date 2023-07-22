(ns clojure-practice.paiza.b-rank-new-level-up-problems.move-simulation-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.move-simulation :refer [load-data move-simulation]]
            [clojure.test :refer [deftest is]]))

(def test-data-1 [{:time 0  :loc [0 0]}
                  {:time 10 :loc [10 10]}])
(def test-data-2 [{:time 0  :loc [0 0]}
                  {:time 3  :loc [-10 -10]}
                  {:time 5 :loc [10 10]}])
(def test-data-3 [{:time 0, :loc [67433 46526]}
                  {:time 3, :loc [4294961088 597]}
                  {:time 6, :loc [36125 4294900275]}
                  {:time 15, :loc [2235 4294911765]}])

(deftest load-data-test
  (with-in-str "2\n0 0 0\n10 10 10"
    (is (= (load-data) test-data-1)))
  (with-in-str "3\n0 0 0\n3 -10 -10\n5 10 10"
    (is (= (load-data) test-data-2)))
  (with-in-str "4\n0 67433 46526\n3 4294961088 597\n6 36125 4294900275\n15 2235 4294911765"
    (is (= (load-data) test-data-3))))

(deftest move-simulation-test
  (is (= (move-simulation test-data-1)
         [[0 0] [1 1] [2 2] [3 3] [4 4] [5 5] [6 6] [7 7] [8 8] [9 9] [10 10]]))
  (is (= (move-simulation test-data-2)
         [[0 0] [-3 -3] [-7 -7] [-10 -10] [0 0] [10 10]])))
