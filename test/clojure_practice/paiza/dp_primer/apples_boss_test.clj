(ns clojure-practice.paiza.dp-primer.apples-boss-test
  (:require
   [clojure-practice.paiza.dp-primer.apples-boss :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest apples-boss-test
  (with-in-str "9 2 100 3 125 5 200\n"
    (let [actual (with-out-str (main))
          expected "375\n"]
      (is (= expected actual)))))
