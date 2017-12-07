(ns advent-of-code-2017.day2part2
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.math.combinatorics :as combo]))
            
(reduce + [1 2 3])

(defn input [f]
  (-> f
      io/resource
      slurp
      str/trim))

(defn is-divisible-pair [[x y]]
  (if (= (mod x y) 0)
    (/ x y)
    (if (= (mod y x) 0)
      (/ y x) 0)))

(->> (input "day2.txt")
     str/split-lines
     (map #(str/split % #"\s+"))
     (map #(map read-string %))
     (map #(combo/combinations % 2))
     (map #(map is-divisible-pair %))
     flatten
     (reduce +))
