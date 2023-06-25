(ns clojure-practice.paiza.forest-contest-001.player-number-test
  (:require [clojure-practice.paiza.forest-contest-001.player-number :refer [read-input-players sort-player]]
            [clojure.test :refer [deftest is testing]]))

(defn input-sample1-list []
  [[83 "PAIZA"] [11 "SUZUKI"] [90 "TANAKA"]])

(defn output-sample1-list []
  [[11 "SUZUKI"] [83 "PAIZA"] [90 "TANAKA"]])

(defn input-sample2-list []
  [[31 "SAITO"]
   [56 "GORO"]
   [11 "IIJIMA"]
   [70 "NAKAMURA"]
   [2 "HAJIME"]])

(defn output-sample2-list []
  [[2 "HAJIME"]
   [11 "IIJIMA"]
   [31 "SAITO"]
   [56 "GORO"]
   [70 "NAKAMURA"]])

(deftest read-input-players-test
  (testing "sample1"
    (with-in-str "3\n83 PAIZA\n11 SUZUKI\n90 TANAKA\n"
      (is (= (read-input-players) (input-sample1-list)))))
  (testing "sample2"
    (with-in-str "5\n31 SAITO\n56 GORO\n11 IIJIMA\n70 NAKAMURA\n2 HAJIME"
      (is (= (read-input-players) (input-sample2-list))))))

(deftest sort-player-test
  (testing "sample1"
    (is (= (sort-player (input-sample1-list)) (output-sample1-list))))
  (testing "sample2"
    (is (= (sort-player (input-sample2-list)) (output-sample2-list)))))
