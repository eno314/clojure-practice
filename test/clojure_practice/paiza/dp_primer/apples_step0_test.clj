(ns clojure-practice.paiza.dp-primer.apples-step0-test
  (:require
   [clojure-practice.paiza.dp-primer.apples-step0 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest apples-step0-test
  (with-in-str "1 100 150\n"
    (let [actual (with-out-str (main))
          expected "100\n"]
      (is (= expected actual))))
  (with-in-str "2 100 150\n"
    (let [actual (with-out-str (main))
          expected "150\n"]
      (is (= expected actual))))
  (with-in-str "3 100 150\n"
    (let [actual (with-out-str (main))
          expected "250\n"]
      (is (= expected actual))))
  (with-in-str "5 100 150\n"
    (let [actual (with-out-str (main))
          expected "400\n"]
      (is (= expected actual)))))
