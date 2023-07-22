(ns clojure-practice.paiza.b-rank-new-level-up-problems.move-simulation-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.move-simulation :refer [load-data]]
            [clojure.test :refer [deftest is]]))

(def test-data-1 [{:time 0  :loc [0 0]}
                  {:time 100 :loc [100 100]}])

(deftest load-data-test
  (with-in-str "2\n0 0 0\n100 100 100"
    (is (= (load-data) test-data-1))))
