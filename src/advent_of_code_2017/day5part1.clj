(ns advent-of-code-2017.day5part1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn input [f]
  (-> f
      io/resource
      slurp
      str/trim))

(defn solve [input index steps]
  (if (or (>= index (count input)) (neg? index))
    steps
    (recur (update input index inc) (+ index (nth input index)) (inc steps))))
      
(defn parse-input [in]
  (->> (input "day5.txt") 
       str/split-lines
       (map read-string)
       vec))

(solve (parse-input (input "day5.txt")) 0 0)
