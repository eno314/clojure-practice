(ns clojure-practice.atcoder.educational-dp-contest.lcs)

(defn- calc-lcs-at [last-t-dp last-t-lcs s t s-idx t-idx]
  (let [s-char (nth s (dec s-idx))
        t-char (nth t (dec t-idx))]
    (if (= s-char t-char)
      (inc (nth last-t-dp (dec t-idx)))
      (max (nth last-t-dp t-idx) last-t-lcs))))

(defn- calc-lcs-t-dp [last-t-dp s t s-idx t-count]
  (loop [t-idx 1
         t-dp [0]]
    (if (< t-count t-idx)
      t-dp
      (recur (inc t-idx)
             (conj t-dp
                   (calc-lcs-at last-t-dp (last t-dp) s t s-idx t-idx))))))

(defn- calc-lcs-dp [s t s-count t-count]
  (loop [s-idx 1
         dp [(vec (repeat (inc t-count) 0))]]
    (if (< s-count s-idx)
      dp
      (recur (inc s-idx)
             (conj dp
                   (calc-lcs-t-dp (last dp) s t s-idx t-count))))))

(defn- get-lcs [dp s t s-count t-count]
  (loop [s-idx s-count
         t-idx t-count
         lcs ""]
    (if (or (zero? s-idx) (zero? t-idx))
      lcs
      (let [s-char (nth s (dec s-idx))
            t-char (nth t (dec t-idx))]
        (if (= s-char t-char)
          (recur (dec s-idx) (dec t-idx) (str s-char lcs))
          (if (> (get-in dp [(dec s-idx) t-idx]) (get-in dp [s-idx (dec t-idx)]))
            (recur (dec s-idx) t-idx lcs)
            (recur s-idx (dec t-idx) lcs)))))))

(defn main
  "https://atcoder.jp/contests/dp/tasks/dp_f
   文字列 s および t が与えられます。
   s の部分列かつ t の部分列であるような文字列のうち、
   最長のものをひとつ求めてください。

   文字列 x の部分列とは、
   x から 0 個以上の文字を取り除いた後、
   残りの文字を元の順序で連結して得られる文字列のことです。

   [input]
   s
   t

   [output]
   s の部分列かつ t の部分列であるような文字列のうち、
   最長のものをひとつ出力せよ。
   答えが複数ある場合、どれを出力してもよい。
   答えが空文字列になることもある。
   "
  []
  (let [s (read-line)
        t (read-line)
        s-count (count s)
        t-count (count t)]
    (-> (calc-lcs-dp s t s-count t-count)
        (get-lcs s t s-count t-count)
        (println))))
