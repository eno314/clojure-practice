(ns clojure-practice.paiza.b-rank-new-level-up-problems.fuel-economy-test
  (:require [clojure-practice.paiza.b-rank-new-level-up-problems.fuel-economy :refer [calc-fuel calc-total-fuel create-moving-distances read-input]]
            [clojure.test :refer [deftest is]]))

(defn input1 []
  {:economy {:change_distance 10
             :starting 7
             :running 3}
   :total_distance 100
   :stop_points [50]})

(defn input2 []
  {:economy {:change_distance 50
             :starting 5
             :running 4}
   :total_distance 100
   :stop_points [30 60]})

(deftest read-input-test
  (with-in-str "10\n7 3\n100 1\n50\n"
    (is (= (read-input) (input1))))
  (with-in-str "50\n5 4\n100 2\n30 60\n"
    (is (= (read-input) (input2)))))

(deftest create-moving-distances-test
  (is (= (create-moving-distances 100 [50]) [50 50]))
  (is (= (create-moving-distances 100 [30 60]) [30 30 40]))
  (is (= (create-moving-distances 200 [10 20 30 40 50]) [10 10 10 10 10 150])))

(deftest calc-fuel-test
  (is (= (calc-fuel {:change_distance 10 :starting 7 :running 3} 50) 190))
  (is (= (calc-fuel {:change_distance 50 :starting 5 :running 4} 30) 150)))

(deftest calc-total-fuel-test
  (is (= (calc-total-fuel (input1)) 380))
  (is (= (calc-total-fuel (input2)) 500)))
