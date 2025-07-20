(ns clojure-practice.paiza.dp-primer.recursive-formula-boss
  (:require
   [clojure-practice.paiza.libs :refer [read-int-lines read-int-value-line]]))

(defn- read-input []
  (-> (read-int-value-line)
      (read-int-lines)))

;; 引数で与えられた数値までのフィボナッチ数列を生成する
(defn- fibonaccis-to [n]
  (loop [idx 2
         fibs [0 1]]
    (if (> idx n)
      fibs
      (recur (inc idx)
             (conj fibs
                   (+ (nth fibs (- idx 1))
                      (nth fibs (- idx 2))))))))

(defn main
  "https://paiza.jp/works/mondai/dp_primer/dp_primer_recursive_formula_boss
   整数 Q と Q 個の整数 k_1, k_2, ... , k_Q が与えられます。
   次のように定められた数列の k_i 項目の値を順に出力してください。
   ・ a_1 = 1
   ・ a_2 = 1
   ・ a_n = a_{n-2} + a_{n-1} (n ≧ 3)
   [input]
   ・ 1行目では、2行目以降で与えられる入力の行数 Q が与えられます。
   ・ 続く Q 行のうち i 行目では、k_i が与えられます。
   [output]
   Q 行出力してください。
   i 行目には、数列の k_i 項目の値を出力してください。
   また、末尾に改行を入れ、余計な文字、空行を含んではいけません。
   a_{k_1}
   a_{k_2}
   ...
   a_{k_Q}"
  []
  (let [targets (read-input)
        fibonaccis (fibonaccis-to (apply max targets))]
    (doseq [target targets]
      (println (get fibonaccis target)))))
