(ns clojure-practice.paiza.dp-primer.lis-continuous-step0-test
  (:require
   [clojure-practice.paiza.dp-primer.lis-continuous-step0 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest lis-continuous-step0-test
  (with-in-str "1\n160\n"
    (let [actual (with-out-str (main))
          expected "1\n"]
      (is (= expected actual))))
  (with-in-str "2\n160\n160\n"
    (let [actual (with-out-str (main))
          expected "2\n"]
      (is (= expected actual))))
  (with-in-str "5\n160\n178\n170\n190\n190\n"
    (let [actual (with-out-str (main))
          expected "3\n"]
      (is (= expected actual)))))
