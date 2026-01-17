(ns clojure-practice.paiza.euclidean-primer.rsa-solve-test
  (:require
   [clojure-practice.paiza.euclidean-primer.rsa-solve :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest rsa-basic-solve
  (testing "sample1"
    (with-in-str "23917 23929 8731 109861231\n"
      (let [actual (with-out-str (main))
            expected "K\n"]
        (is (= expected actual)))))
  (testing "sample2"
    (with-in-str "21283 21313 2843 315549360\n"
      (let [actual (with-out-str (main))
            expected "p\n"]
        (is (= expected actual))))))
