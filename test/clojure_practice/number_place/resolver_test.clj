(ns clojure-practice.number-place.resolver-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure-practice.number-place.resolver :as core]))

(deftest main-test
  (testing "全て数字が埋まっていたらのまま返す"
    (let [input "534678912\n672195348\n198342567\n859761423\n426853791\n713924856\n961537284\n287419635\n345286179"
          expected-output (str input "\n")
          temp-file (doto (java.io.File/createTempFile "full-number-place" ".txt")
                      (.deleteOnExit))]
      (spit temp-file input)
      (let [output (with-out-str
                     (core/-main (.getPath temp-file)))]
        (is (= expected-output output)))))

  (testing "引数がない場合はエラーメッセージを出力する"
    (let [expected-error "Error: Please provide a file path as an argument\n"
          output (with-out-str
                   (core/-main))]
      (is (= expected-error output))))

  (testing "9行でない場合はエラーメッセージを出力する"
    (let [input "534678912\n672195348\n198342567"
          expected-error "Error: Input must be 9 lines\n"
          temp-file (doto (java.io.File/createTempFile "invalid-lines" ".txt")
                      (.deleteOnExit))]
      (spit temp-file input)
      (let [output (with-out-str
                     (core/-main (.getPath temp-file)))]
        (is (= expected-error output)))))

  (testing "1行が9文字でない場合はエラーメッセージを出力する"
    (let [input "534678912\n672195348\n198342567\n859761423\n426853791\n713924856\n961537284\n287419635\n34528617"
          expected-error "Error: Each line must be 9 characters\n"
          temp-file (doto (java.io.File/createTempFile "invalid-chars" ".txt")
                      (.deleteOnExit))]
      (spit temp-file input)
      (let [output (with-out-str
                     (core/-main (.getPath temp-file)))]
        (is (= expected-error output)))))

  (testing "1-9以外の文字が含まれる場合はエラーメッセージを出力する"
    (let [input "534678912\n672195348\n198342567\n859761423\n426853791\n713924856\n961537284\n287419635\n34528617a"
          expected-error "Error: Each character must be a digit from 1 to 9 or .\n"
          temp-file (doto (java.io.File/createTempFile "invalid-digits" ".txt")
                      (.deleteOnExit))]
      (spit temp-file input)
      (let [output (with-out-str
                     (core/-main (.getPath temp-file)))]
        (is (= expected-error output)))))

  (testing "ファイルが存在しない場合はエラーメッセージを出力する"
    (let [non-existent-file "non-existent-file.txt"
          expected-error "Error: File does not exist\n"
          output (with-out-str
                   (core/-main non-existent-file))]
      (is (= expected-error output))))

  (testing "ディレクトリを指定した場合はエラーメッセージを出力する"
    (let [temp-dir (doto (java.io.File/createTempFile "temp-dir" "")
                     (.delete)
                     (.mkdir)
                     (.deleteOnExit))
          expected-error "Error: Path is not a file\n"
          output (with-out-str
                   (core/-main (.getPath temp-dir)))]
      (is (= expected-error output)))))
