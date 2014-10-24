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
(def number-of-vertices (count readstuff))

(defn iterategraph []
  "This populates the map graph so that it that every node is a key and every value is a neighbor of the node"
  (def graph {})
(loop [iteration 0]
  (def workingvertex (nth readstuff iteration))
  (def a (merge-with clojure.set/union graph {(keyword (first workingvertex)) #{(read-string (last workingvertex))}}))
  (def b (merge-with clojure.set/union graph {(keyword (last workingvertex)) #{(read-string (first workingvertex))}}))
  (def graph (merge-with clojure.set/union a b))
  (if (> iteration (- number-of-vertices 2))
    (println "Graph Generated!")
    (recur (inc iteration)))))
(defn printgraph [] (println (into (sorted-map) graph)))
  (defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

 ;; This recursion will find the distance to all the nodes starting from a node.
 ;; Key points: Find neighbors, add n*neighbors to distance, add neighbors to visited-nodes, visit neighbor's-neighbors
 ;;   add (n+1)*neighbors-neighbors).
 (def edges (keys graph))
 (def to-visit (set (map read-string (map name edges))))
 (def current-edge (nth edges 0))
 (def neighbors (get graph current-edge))
 (clojure.set/difference to-visit current-edge)
 (def number-of-edges (count edges))
 (def n 1)
 (def distance 0)
 (def distance (+ (* n (count neighbors)) distance))

 (defn fib
  ([n]
     (fib [0 1] n))
  ([x, n]
     (if (< (count x) n)
       (fib (conj x (+ (last x) (nth x (- (count x) 2)))) n)
       x)))

;; (println "working edge: " workingvertex)
;;  (def a (merge-with clojure.set/union graph {(keyword (first workingvertex)) #{(read-string (last workingvertex))}}))
;;  (def b (merge-with clojure.set/union graph {(keyword (last workingvertex)) #{(read-string (first workingvertex))}}))

;; (def graph {:1 [:2 :3], :2 [:1 :4], :3 [:1 :4], :4 [:2 :3]})
;;getting edges
;; (:1 graph)
;; conj adds elm to end of vector
;; (conj (:1 graph) :3 :4)
;; finds :3 in vector
;; (some #(= :3 %) (:1 a))
;; (name :1)
;; (keyword "aeevireikey")
;; (in? [:1 a] :1)
;; (get [3 2 1] 0)
;; by index
;; (if #(= 4 %) :3)
