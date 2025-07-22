(ns clojure-practice.paiza.dp-primer.lis-step0-test
  (:require
   [clojure-practice.paiza.dp-primer.lis-step0 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest lis-step0-test
  (with-in-str "5\n100\n101\n102\n103\n104\n"
    (let [actual (with-out-str (main))
          expected "5\n"]
      (is (= expected actual))))
  (with-in-str "5\n104\n104\n102\n101\n100\n"
    (let [actual (with-out-str (main))
          expected "1\n"]
      (is (= expected actual))))
  (with-in-str "5\n110\n105\n102\n101\n104\n"
    (let [actual (with-out-str (main))
          expected "2\n"]
      (is (= expected actual))))
  (with-in-str "5\n100\n102\n101\n99\n199\n"
    (let [actual (with-out-str (main))
          expected "3\n"]
      (is (= expected actual)))))
