(ns clojure-practice.paiza.euclidean-primer.rsa-verification-test
  (:require
   [clojure-practice.paiza.euclidean-primer.rsa-verification :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest rsa-verification
  (testing "sample"
    (let [expected "9998000099 65537 6337020097\nWOW!\n"]
      (is (= expected (with-out-str (main)))))))
