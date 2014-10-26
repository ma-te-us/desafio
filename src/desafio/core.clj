(ns desafio.core
  (:gen-class)
  (:require [clojure.set :as set]
  [clojure.string :as str]))

(def graph {})

;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(defn split-line [line]
  "Splits a line of text into a sequence of strings source: pastebin.com/X9yBjJx"
  (str/split line #" "))

(defn read-lines [filename]
  "Reads a file and returns a sequence made up of a vector for each line"
  (with-open [reader (clojure.java.io/reader filename)]
    (for [line (doall (line-seq reader))] (split-line line))))

(def readstuff (read-lines "/Users/mateus/Github/desafio/nodes"))

(def number-of-edges (count readstuff))

(defn iterategraph []
  "This populates the map graph so that it that every node is a key and every value is a neighbor of the node"
  (def graph {})
(loop [iteration 0]
  (def workingvertex (nth readstuff iteration))
  (def a (merge-with clojure.set/union graph {(keyword (first workingvertex)) #{(keyword (last workingvertex))}}))
  (def b (merge-with clojure.set/union graph {(keyword (last workingvertex)) #{(keyword (first workingvertex))}}))
  (def graph (merge-with clojure.set/union a b))
  (if (> iteration (- number-of-edges 2))
    (println "Graph Generated!")
    (recur (inc iteration)))))

(defn printgraph [] (println (into (sorted-map) graph)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

 (def nodes (keys graph))
 (def to-visit (set nodes))
 (def visited #{})
 (def number-of-nodes (count nodes))

 ;; This recursion will find the distance to all the nodes starting from a node.
 ;; Function #1: Given a node, get it's neighbors.

(defn node-to-neighbors [nodeindex]
 (def current-node (nth nodes nodeindex))
   (def neighbors (clojure.set/difference (get graph current-node) visited)) ; So it won't visit nodes twice.
   (def visited (clojure.set/union neighbors visited))
   (def n 1)
  (def distance 0)
  (find-neighbors neighbors n)
  )
 ;; Given neighbors, find neighbors' neighbors.
 (defn find-neighbors [x n]
  (def neighborsneighbors #{})
   (map #(def neighborsneighbors (clojure.set/union (get graph %) neighborsneighbors)) (into (vector) neighbors))
   (def neighborsneighbors (clojure.set/difference neighborsneighbors visited))

   )


   (def distance (+ (* n (count neighbors)) distance))
   (distance-sum-recur neighborsneighbors n)
(defn distance-sum-recur [neighborsneighbors n]
  (def distance (+ (* (+ n 1) (count neighborsneighbors)) distance))

  )
