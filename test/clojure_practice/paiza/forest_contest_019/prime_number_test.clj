(ns clojure-practice.paiza.forest-contest-019.prime-number-test
  (:require
   [clojure-practice.paiza.forest-contest-019.prime-number :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest prime-number-test
  (testing "No"
    (with-in-str "4" (is (= "No\n" (with-out-str (main)))))
    (with-in-str "6" (is (= "No\n" (with-out-str (main)))))
    (with-in-str "169" (is (= "No\n" (with-out-str (main)))))
    ;(with-in-str "9223372036854775805" (is (= "No\n" (with-out-str (main)))))
    (with-in-str "813" (is (= "No\n" (with-out-str (main))))))

  (testing "Yes"
    (with-in-str "3" (is (= "Yes\n" (with-out-str (main)))))
    (with-in-str "10007" (is (= "Yes\n" (with-out-str (main)))))
    ;(with-in-str "2147483647" (is (= "Yes\n" (with-out-str (main)))))
    ;(with-in-str "9132039623613475357" (is (= "Yes\n" (with-out-str (main)))))
    (with-in-str "2" (is (= "Yes\n" (with-out-str (main)))))))
