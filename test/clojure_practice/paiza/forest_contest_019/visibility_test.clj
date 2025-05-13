(ns clojure-practice.paiza.forest-contest-019.visibility-test
  (:require
   [clojure-practice.paiza.forest-contest-019.visibility :refer [main]]
   [clojure.test :refer [deftest is testing]]))

(deftest visibility-test
  (testing "2*2マスのテスト"
    (with-in-str "2 2\nTT\nTA"
      (is (= "TT\nTA\n" (with-out-str (main)))))
    (with-in-str "2 2\nA.\n.."
      (is (= "AV\nV.\n" (with-out-str (main)))))
    (with-in-str "2 2\n..\n.A"
      (is (= ".V\nVA\n" (with-out-str (main))))))

  (testing "サンプル"
    (with-in-str "4 5\nT.TTT\n.....\nT..AT\nTTTTT"
      (is (= "T.TTT\n...V.\nTVVAT\nTTTTT\n" (with-out-str (main)))))
    (with-in-str (str "10 10\n"
                      "TTTTTTTTTT\n"
                      "TTTTTT...T\n"
                      "T.........\n"
                      "TT....A..T\n"
                      "T....T...T\n"
                      "T...T....T\n"
                      "T........T\n"
                      "T........T\n"
                      "T..T.....T\n"
                      "T........T\n")
      (is (= (str "TTTTTTTTTT\n"
                  "TTTTTTV..T\n"
                  "T.....V...\n"
                  "TTVVVVAVVT\n"
                  "T....TV..T\n"
                  "T...T.V..T\n"
                  "T.....V..T\n"
                  "T.....V..T\n"
                  "T..T..V..T\n"
                  "T.....V..T\n")
             (with-out-str (main)))))))
