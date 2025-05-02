(ns clojure-practice.number-place.resolver
  (:require
   [clojure-practice.number-place.input-converter :refer [board-data-to-output-str
                                                          input-args-to-board-data]]
   [clojure-practice.number-place.validator :refer [valid-board?]]))

(defn resolve-number-place [board-data]
  (if (valid-board? board-data)
    board-data
    (throw (Exception. "Invalid number place pattern"))))

(defn -main [& args]
  (try
    (-> (input-args-to-board-data args)
        (resolve-number-place)
        (board-data-to-output-str)
        (println))
    (catch Exception e
      (println (str "Error: " (.getMessage e))))))
