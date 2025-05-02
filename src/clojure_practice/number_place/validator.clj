(ns clojure-practice.number-place.validator)

(defn- no-duplicate-numbers? [numbers]
  (let [numbers-without-nil (filter some? numbers)]
    (= (count numbers-without-nil) (count (set numbers-without-nil)))))

(defn- no-duplicate-in-column? [board col-index]
  (no-duplicate-numbers? (mapv #(nth % col-index) board)))

(defn- no-duplicate-in-block? [board block-index]
  (let [first-row (* (quot block-index 3) 3)
        first-col (* (rem block-index 3) 3)]
    (-> (for [row-idx (range 3)
              col-idx (range 3)]
          (get-in board [(+ first-row row-idx) (+ first-col col-idx)]))
        (no-duplicate-numbers?))))

(defn valid-board? [board-data]
  (and (every? no-duplicate-numbers? board-data)
       (every? #(no-duplicate-in-column? board-data %) (range 9))
       (every? #(no-duplicate-in-block? board-data %) (range 9))))
