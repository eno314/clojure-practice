(ns clojure-practice.paiza.graph-input-problems.loops-multiple-edges-step1-test
  (:require
   [clojure-practice.paiza.graph-input-problems.loops-multiple-edges-step1 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest loops-multiple-edges-step1-test
  (with-in-str "3\n0 1 0\n1 0 1\n0 1 0\n"
    (let [actual (with-out-str (main))
          expected "0\n"]
      (is (= expected actual))))
  (with-in-str (str "5\n"
                    "0 1 1 0 0\n"
                    "1 1 0 1 1\n"
                    "1 0 0 0 0\n"
                    "0 1 0 1 1\n"
                    "0 1 0 1 0\n")
    (let [actual (with-out-str (main))
          expected "2\n2\n4\n"]
      (is (= expected actual))))
  (with-in-str (str "5\n"
                    "0 1 1 0 0\n"
                    "1 0 0 1 1\n"
                    "1 0 0 0 0\n"
                    "0 1 0 0 1\n"
                    "0 1 0 1 0\n")
    (let [actual (with-out-str (main))
          expected "0\n"]
      (is (= expected actual)))))
