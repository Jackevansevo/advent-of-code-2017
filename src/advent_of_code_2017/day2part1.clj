(ns advent-of-code-2017.day2part1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn input [f]
  (-> f
      io/resource
      slurp
      str/trim))

(->> (input "day2.txt")
     str/split-lines
     (map #(str/split % #"\s+"))
     (map #(map read-string %))
     (map #(- (apply max %) (apply min %)))
     (reduce +))
     
