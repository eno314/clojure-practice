(ns clojure-practice.core)


(defn read-input []
  {})

(defn input-to-output [input-data]
  [])

(defn write-output [output-data]
  (doseq [n output-data] (println n)))

(defn main []
  (as-> (read-input) data
    (input-to-output data)
    (write-output data)))

(defn -main [] (main))
