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

(def readstuff (read-lines "/Users/mateus/Github/desafio/edges"))

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
  (println "Hello, World!")
  )

 (def nodes (keys graph))
 (def to-visit (set nodes))
 (def visited #{})
 (def distance 0)
 (def number-of-nodes (count nodes))


 ;; Given neighbors, find neighbors' neighbors.
 (defn find-neighbors [x n current-node]
   (def neinei #{})
   (def neinei (apply clojure.set/union (map #(get graph %) x)))
   (def neinei (clojure.set/difference neinei visited))
   (def visited (clojure.set/union neinei visited))
   (def distance (+ (* (+ n 1) (count x)) distance))
   (if (= (count neinei) 0)
     (def solution (merge-with clojure.set/union {current-node (/ 1 distance)} solution))
     (find-neighbors neinei (+ 1 n) current-node))
   )

 ;; This recursion will find the distance to all the nodes starting from a node.

 ;; Function #1: Given a node, get it's neighbors.

(defn node-to-neighbors [nodeindex]
  (def nodes (keys graph))
  (def current-node (nth nodes nodeindex))
  (def neighbors (get graph current-node)) ; So it won't visit nodes twice.
  (def visited neighbors)
  (def n 1)
  (def distance 0)
  (def distance (+ (* n (count neighbors)) distance))
  (find-neighbors neighbors n current-node)
  )

 (defn print-solution []
 (iterategraph)
 (def solution #{})
 (doall (map #(node-to-neighbors %) (range 99)))
   (println "Nodes in order of \"Closeness\" in the form [:Node Closeness]")
  (println (sort-by val > solution))
   )
