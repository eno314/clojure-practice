(ns clojure-practice.paiza.euclidean-primer.lcm-test
  (:require
   [clojure-practice.paiza.euclidean-primer.lcm :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest lcm
  (testing "sample1"
    (with-in-str "6 39"
      (let [actual (with-out-str (main))
            expected "78\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "2464 2461"
      (let [actual (with-out-str (main))
            expected "6054704\n"]
        (is (= expected actual))))))
