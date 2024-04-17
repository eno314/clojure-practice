(ns clojure-practice.core-test
  (:require [clojure-practice.core :refer [input-to-output read-input]]
            [clojure.test :refer [deftest is testing]]))

(deftest test-read-input
  (testing "test case sample"
    (with-in-str ""
      (is (= (read-input) {})))))

(deftest test-input-to-output
  (testing "test case sample"
    (is (= (input-to-output {}) []))))
