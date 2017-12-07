(ns advent-of-code-2017.day1part1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))
  
(defn input [f]
  (-> f
      io/resource
      slurp
      str/trim))

(defn parse-matches [a b]
  (if (= a b) 
    (Character/digit a 10) 0))

(defn solve [txt]
  (reduce + (map parse-matches txt (drop 1 (cycle txt)))))

(solve (input "day1.txt"))
