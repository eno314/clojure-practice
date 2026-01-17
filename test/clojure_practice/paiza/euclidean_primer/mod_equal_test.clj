(ns clojure-practice.paiza.euclidean-primer.mod-equal-test
  (:require
   [clojure-practice.paiza.euclidean-primer.mod-equal :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest mod-equal
  (testing "sample1"
    (with-in-str "10000 1\n"
      (let [actual (with-out-str (main))
            expected "1\n10001\n20001\n30001\n40001\n50001\n60001\n70001\n80001\n90001\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "28446 39582\n"
      (let [actual (with-out-str (main))
            expected "11136\n39582\n68028\n96474\n"]
        (is (= expected actual))))))


