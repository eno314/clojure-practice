(ns clojure-practice.paiza.forest-contest-019.count-abc)

(defn- count-char-in-str [str c]
  (count (filter #(= c %) str)))

(defn main []
  (let [_ (read-line)
        line (read-line)]
    (println (count-char-in-str line \A))
    (println (count-char-in-str line \B))
    (println (count-char-in-str line \C))))
