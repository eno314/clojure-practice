(ns clojure-practice.paiza.dp-primer.stairs-boss-test
  (:require
   [clojure-practice.paiza.dp-primer.stairs-boss :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest stairs-boss-test
  (with-in-str "10 2 3 4\n"
    (let [actual (with-out-str (main))
          expected "17\n"]
      (is (= expected actual)))))
