(ns clojure-practice.number-place.resolver-test
  (:require
   [clojure-practice.number-place.resolver :as core]
   [clojure.test :refer [deftest is testing]]))

(defn- acceptance-test [input-file-content expected-output-str]
  (let [temp-file (doto (java.io.File/createTempFile "full-number-place" ".txt")
                    (.deleteOnExit))]
    (spit temp-file input-file-content)
    (-> (with-out-str (core/-main (.getPath temp-file)))
        (= expected-output-str)
        (is))))

(deftest main-test
  (testing "全て数字が埋まっていたらのまま返す"
    (let [input-file-content (str "534678912\n"
                                  "672195348\n"
                                  "198342567\n"
                                  "859761423\n"
                                  "426853791\n"
                                  "713924856\n"
                                  "961537284\n"
                                  "287419635\n"
                                  "345286179\n")]
      (acceptance-test input-file-content, input-file-content)))

  (testing "1つ数字が埋まっていないとき"
    (let [input-file-content (str "534678912\n"
                                  "672195348\n"
                                  "198342567\n"
                                  "859761423\n"
                                  "426853791\n"
                                  "713924856\n"
                                  "961537284\n"
                                  "287419635\n"
                                  "34528617.")
          expected (str "534678912\n"
                        "672195348\n"
                        "198342567\n"
                        "859761423\n"
                        "426853791\n"
                        "713924856\n"
                        "961537284\n"
                        "287419635\n"
                        "345286179\n")]
      (acceptance-test input-file-content, expected)))

  (testing "複数数字が埋まっていないとき"
    (let [input-file-content (str "..4678912\n"
                                  "..2195348\n"
                                  "198342567\n"
                                  "859761423\n"
                                  "426853791\n"
                                  "713924856\n"
                                  "961537284\n"
                                  "2874196..\n"
                                  ".452861..")
          expected (str "534678912\n"
                        "672195348\n"
                        "198342567\n"
                        "859761423\n"
                        "426853791\n"
                        "713924856\n"
                        "961537284\n"
                        "287419635\n"
                        "345286179\n")]
      (acceptance-test input-file-content, expected)))

  (testing "引数がない場合はエラーメッセージを出力する"
    (let [expected-error "Error: Please provide a file path as an argument\n"
          output (with-out-str (core/-main))]
      (is (= expected-error output))))

  (testing "9行でない場合はエラーメッセージを出力する"
    (acceptance-test (str "534678912\n"
                          "672195348\n"
                          "198342567")
                     "Error: Input must be 9 lines\n"))

  (testing "1行が9文字でない場合はエラーメッセージを出力する"
    (acceptance-test (str "534678912\n"
                          "672195348\n"
                          "198342567\n"
                          "859761423\n"
                          "426853791\n"
                          "713924856\n"
                          "961537284\n"
                          "287419635\n"
                          "34528617")
                     "Error: Each line must be 9 characters\n"))

  (testing "1-9以外の文字が含まれる場合はエラーメッセージを出力する"
    (acceptance-test (str "534678912\n"
                          "672195348\n"
                          "198342567\n"
                          "859761423\n"
                          "426853791\n"
                          "713924856\n"
                          "961537284\n"
                          "287419635\n"
                          "34528617a")
                     "Error: Each character must be a digit from 1 to 9 or .\n"))

  (testing "ファイルが存在しない場合はエラーメッセージを出力する"
    (let [non-existent-file "non-existent-file.txt"
          expected-error "Error: File does not exist\n"
          output (with-out-str (core/-main non-existent-file))]
      (is (= expected-error output))))

  (testing "ディレクトリを指定した場合はエラーメッセージを出力する"
    (let [temp-dir (doto (java.io.File/createTempFile "temp-dir" "")
                     (.delete)
                     (.mkdir)
                     (.deleteOnExit))
          expected-error "Error: Path is not a file\n"
          output (with-out-str (core/-main (.getPath temp-dir)))]
      (is (= expected-error output))))

  (testing "行に重複がある場合はエラーメッセージを出力する"
    (acceptance-test (str "123456781\n"
                          ".........\n"
                          ".........\n"
                          ".........\n"
                          ".........\n"
                          ".........\n"
                          ".........\n"
                          ".........\n"
                          ".........")
                     "Error: Invalid number place pattern\n"))

  (testing "列に重複がある場合はエラーメッセージを出力する"
    (acceptance-test (str "1........\n"
                          "2........\n"
                          "3........\n"
                          "4........\n"
                          "5........\n"
                          "6........\n"
                          "7........\n"
                          "8........\n"
                          "1........")
                     "Error: Invalid number place pattern\n"))

  (testing "3x3のブロックに重複がある場合はエラーメッセージを出力する"
    (acceptance-test (str "123......\n"
                          "456......\n"
                          "781......\n"
                          ".........\n"
                          ".........\n"
                          ".........\n"
                          ".........\n"
                          ".........\n"
                          ".........")
                     "Error: Invalid number place pattern\n")))
