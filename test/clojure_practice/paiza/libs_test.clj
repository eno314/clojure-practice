(ns clojure-practice.paiza.libs-test
  (:require [clojure-practice.paiza.libs :refer [read-int-value-line readlines
                                                 split-line-by-comma
                                                 split-line-by-space]]
            [clojure.test :refer [deftest is testing]]))

(deftest test-readlines
  (testing "readlines with line-length 3"
    (with-in-str "1\n2\n3\n4\n5\n"
      (is (= (readlines 3) ["1" "2" "3"]))))
  (testing "readlines with line-length 5"
    (with-in-str "a\nbb\nccc\ndddd\neeeee\n"
      (is (= (readlines 5) ["a" "bb" "ccc" "dddd" "eeeee"])))))


(deftest test-read-int-value-line
  (with-in-str "123\n"
    (is (= (read-int-value-line) 123))))

(deftest test-split-line-by-space
  (is (= (split-line-by-space "Hello, world!") ["Hello," "world!"]))
  (is (= (split-line-by-space "1 2 3 4 5") ["1" "2" "3" "4" "5"]))
  (is (= (split-line-by-space "abcde") ["abcde"])))

(deftest test-split-line-by-comma
  (is (= (split-line-by-comma "Hello, world!") ["Hello" " world!"]))
  (is (= (split-line-by-comma "1,2,3,4,5") ["1" "2" "3" "4" "5"]))
  (is (= (split-line-by-comma "abcde") ["abcde"])))