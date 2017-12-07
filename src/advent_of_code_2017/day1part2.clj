(ns advent-of-code-2017.day1part2
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))
  
(defn input [f]
  (-> f
      io/resource
      slurp
      str/trim))

(defn split-half [s]
  (split-at (/ (count s) 2) s))

(defn solve [txt]
  (let [halfs (split-half txt)] 
    (reduce 
      + 
      (map 
        (fn [[a b]] 
          (if (= a b) 
            (* (Character/digit a 10) 2) 0))
        (apply map vector halfs)))))

(solve (input "day1.txt"))
