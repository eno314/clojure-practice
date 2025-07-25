(ns clojure-practice.paiza.dp-primer.partial-sums-step1-test
  (:require
   [clojure-practice.paiza.dp-primer.partial-sums-step1 :refer [main]]
   [clojure.test :refer [deftest is]]))

(deftest partial-sums-step1-test
  ;; 現在のテストケース（偶然通っている）
  (with-in-str "3 10\n1\n2\n3\n"
    (let [actual (with-out-str (main))
          expected "0\n"]
      (is (= expected actual))))
  (with-in-str "5 10\n7\n3\n4\n3\n2\n"
    (let [actual (with-out-str (main))
          expected "3\n"]
      (is (= expected actual))))

  ;; 問題を明確に示すテストケース
  ;; 重さ1のおもり1個で重さ1を作る方法は1通り
  (with-in-str "1 1\n1\n"
    (let [actual (with-out-str (main))
          expected "1\n"]
      (is (= expected actual))))

  ;; 重さ1,2のおもり2個で重さ3を作る方法は1通り（1+2）
  (with-in-str "2 3\n1\n2\n"
    (let [actual (with-out-str (main))
          expected "1\n"]
      (is (= expected actual))))

  ;; 重さ1,1のおもり2個で重さ1を作る方法は2通り（1番目を選ぶ or 2番目を選ぶ）
  (with-in-str "2 1\n1\n1\n"
    (let [actual (with-out-str (main))
          expected "2\n"]
      (is (= expected actual))))

  ;; 重さ1,1,2のおもり3個で重さ2を作る方法は2通り（1番目の1+2, 2番目の1+2）
  (with-in-str "3 3\n1\n1\n2\n"
    (let [actual (with-out-str (main))
          expected "2\n"]
      (is (= expected actual)))))
