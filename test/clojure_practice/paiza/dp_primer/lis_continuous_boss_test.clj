(ns clojure-practice.paiza.dp-primer.lis-continuous-boss-test
  (:require
   [clojure-practice.paiza.dp-primer.lis-continuous-boss :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest lis-continuous-boss-test
  (with-in-str "5\n187\n192\n115\n108\n109\n"
    (let [actual (with-out-str (main))
          expected "3\n"]
      (is (= expected actual)))))
