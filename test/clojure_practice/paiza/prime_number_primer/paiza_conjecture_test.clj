(ns clojure-practice.paiza.prime-number-primer.paiza-conjecture-test
  (:require
   [clojure-practice.paiza.prime-number-primer.paiza-conjecture :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest paiza-conjecture
  (testing "sample"
    (let [actual (with-out-str (main))
          expected "33016\n"]
      (is (= expected actual)))))

