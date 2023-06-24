(ns clojure-practice.paiza.input)

;https://paiza.jp/works/mondai/stdin/stdin_3_line
;標準入力で3行それぞれで文字列が与えられるので、それらを入力して、そのまま3行で出力してください。
(defn readlines [line-lenght]
  (take line-lenght (repeatedly read-line)))

(doseq [line (readlines 3)]
  (println line))

;https://paiza.jp/works/mondai/stdin/stdin_n_line
;1行目でNが与えらます。続くN行の各行で文字列が与えられます。
(defn readIntValueLine []
  (Integer/parseInt (read-line)))

(doseq [line (readlines (readIntValueLine))]
  (println line))

;https://paiza.jp/works/mondai/stdin/stdin_3
;標準入力で3つの文字列が1行で与えられるので、それらを入力して、順にそのまま3行で出力してください。
(defn splitLineBySpace [line]
  (clojure.string/split line #" "))

(doseq [line (splitLineBySpace (read-line))]
  (println line))

;https://paiza.jp/works/mondai/stdin/stdin_n
(let [n (readIntValueLine)]
  (let [values (splitLineBySpace (read-line))]
    (cond
      (= n (count values))
      (doseq [value values]
        (println value))
      :else
      (throw (Exception. "invalid input")))))

;https://paiza.jp/works/mondai/stdin/stdin_comma_3
(defn splitLineByComma [line]
  (clojure.string/split line #","))

(doseq [line (splitLineByComma (read-line))]
  (println line))

;https://paiza.jp/works/mondai/stdin/stdin_comma_n
(let [n (readIntValueLine)]
  (let [values (splitLineByComma (read-line))]
    (cond
      (= n (count values))
      (doseq [value values]
        (println value))
      :else
      (throw (Exception. "invalid input")))))