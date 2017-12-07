(ns advent-of-code-2017.day4part2
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn input [f]
  (-> f
      io/resource
      slurp
      str/trim))

(defn is-valid [in]
  (let [letters (map (comp sort vec) (str/split in #"\s"))]
    (= (distinct letters) letters)))

(defn solve []
  (->> (input "day4.txt")
       (str/split-lines)
       (map is-valid)
       (filter identity)
       count))

(solve)
