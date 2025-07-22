(ns clojure-practice.paiza.dp-primer.lis-boss-test
  (:require
   [clojure-practice.paiza.dp-primer.lis-boss :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest lis-boss-test
  (with-in-str "5\n100\n101\n102\n103\n104\n"
    (let [actual (with-out-str (main))
          expected "1\n"]
      (is (= expected actual))))
  (with-in-str "5\n104\n104\n102\n101\n100\n"
    (let [actual (with-out-str (main))
          expected "4\n"]
      (is (= expected actual))))
  (with-in-str "5\n109\n110\n108\n103\n100\n"
    (let [actual (with-out-str (main))
          expected "4\n"]
      (is (= expected actual)))))
