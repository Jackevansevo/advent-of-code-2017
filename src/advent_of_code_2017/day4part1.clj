(ns advent-of-code-2017.day4part1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn input [f]
  (-> f
      io/resource
      slurp
      str/trim))

(defn solve [] 
    (->> (input "day4.txt")
         (str/split-lines)
         (map #(str/split % #"\s"))
         (map #(= (distinct %) %))
         (filter identity)
         count))

(solve)
