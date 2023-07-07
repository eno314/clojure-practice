(ns clojure-practice.paiza.b-rank-new-level-up-problems.fuel-economy-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.fuel-economy :refer [read-input]]
            [clojure.test :refer [deftest is]]))

(deftest read-input-test
  (with-in-str "10\n7 3\n100 1\n50\n"
    (is (= (read-input)
           {:economy {:change_distance 10
                      :starting 7
                      :running 3}
            :total_distance 100
            :stop_distances [50]})))
  (with-in-str "50\n5 4\n100 2\n30 60\n"
    (is (= (read-input)
           {:economy {:change_distance 50
                      :starting 5
                      :running 4}
            :total_distance 100
            :stop_distances [30 60]}))))
