(ns clojure-practice.paiza.dp-primer.partial-sums-boss-test
  (:require
   [clojure-practice.paiza.dp-primer.partial-sums-boss :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest partial-sums-boss-test
  (testing "重さの和が10になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "3 10\n3\n4\n5\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "重さの和が7になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "3 7\n3\n4\n5\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "重さの和が6になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "3 6\n3\n4\n5\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "重さの和が5になる場合（不可能）- 同じおもりを複数回使用"
    (with-in-str "2 5\n3\n4\n"
      (let [actual (with-out-str (main))
            expected "no\n"]
        (is (= expected actual)))))

  (testing "重さの和が8になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "3 8\n3\n4\n5\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "重さの和が0になる場合（可能）"
    (with-in-str "3 0\n3\n4\n5\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "おもりが1つで重さの和が6になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "1 6\n3\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "おもりが1つで重さの和が7になる場合（不可能）- 同じおもりを複数回使用"
    (with-in-str "1 7\n3\n"
      (let [actual (with-out-str (main))
            expected "no\n"]
        (is (= expected actual)))))

  (testing "おもりが1つで重さの和が9になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "1 9\n3\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "おもりが1つで重さの和が10になる場合（不可能）- 同じおもりを複数回使用"
    (with-in-str "1 10\n3\n"
      (let [actual (with-out-str (main))
            expected "no\n"]
        (is (= expected actual)))))

  (testing "おもりが2つで重さの和が7になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "2 7\n3\n4\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "おもりが2つで重さの和が8になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "2 8\n3\n4\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "おもりが2つで重さの和が9になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "2 9\n3\n4\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "おもりが2つで重さの和が11になる場合（可能）- 同じおもりを複数回使用"
    (with-in-str "2 10\n3\n4\n"
      (let [actual (with-out-str (main))
            expected "yes\n"]
        (is (= expected actual)))))

  (testing "おもりが2つで重さの和が11になる場合（不可能）- 同じおもりを複数回使用"
    (with-in-str "2 11\n3\n6\n"
      (let [actual (with-out-str (main))
            expected "no\n"]
        (is (= expected actual))))))
