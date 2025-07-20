(ns clojure-practice.paiza.dp-primer.recursive-formula-boss-test
  (:require
   [clojure-practice.paiza.dp-primer.recursive-formula-boss :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest recursive-formula-boss-test
  (with-in-str "5\n1\n2\n3\n4\n3\n"
    (let [actual (with-out-str (main))
          expected "1\n1\n2\n3\n2\n"]
      (is (= expected actual))))
  (with-in-str "2\n39\n40\n"
    (let [actual (with-out-str (main))
          expected "63245986\n102334155\n"]
      (is (= expected actual)))))
