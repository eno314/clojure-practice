(ns clojure-practice.number-place.resolver
  (:require
   [clojure-practice.number-place.board :refer [find-board-empty-pos
                                                valid-board?]]
   [clojure-practice.number-place.in-out-converter :refer [board-data-to-output-str
                                                           input-args-to-board-data]]))

(defn- resolve-number-place [board-data]
  (if-let [empty-pos (find-board-empty-pos board-data)]
    (some (fn [num]
            (let [new-board (assoc-in board-data empty-pos num)]
              (when (valid-board? new-board) (resolve-number-place new-board))))
          (range 1 10))
    board-data))

(defn -main [& args]
  (try
    (-> (input-args-to-board-data args)
        (resolve-number-place)
        (board-data-to-output-str)
        (println))
    (catch Exception e
      (println (str "Error: " (.getMessage e))))))
