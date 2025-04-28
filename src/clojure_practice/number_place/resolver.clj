(ns clojure-practice.number-place.resolver
  (:require
   [clojure-practice.number-place.input-converter :refer [board-data-to-output-str
                                                          input-args-to-board-data]]))

(defn resolve [board-data]
  board-data)

(defn -main [& args]
  (try
    (-> (input-args-to-board-data args)
        (resolve)
        (board-data-to-output-str)
        (println))
    (catch Exception e
      (println (str "Error: " (.getMessage e))))))
