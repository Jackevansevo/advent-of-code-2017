(ns advent-of-code-2017.day6part1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def puzzle-input [0 5 10 0 11 14 13 4 11 8 8 7 1 4 12 11])

(defn redistribute [input index blocks]
  (if (= blocks 0)
    input
    (if (= index (count input))
      (recur input 0 blocks)
      (recur (update input index inc) (inc index) (dec blocks)))))


(defn solve [input prev]
  (let [max-val (apply max input)
        max-idx (.indexOf input max-val)
        new-val (redistribute (assoc input max-idx 0) (inc max-idx) max-val)]
    (if (contains? prev new-val)
      (inc (count prev))
      (solve new-val (conj prev new-val)))))
    
(solve puzzle-input (set []))
