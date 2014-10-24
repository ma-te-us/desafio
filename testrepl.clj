;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.

(def readstuff (read-lines "/Users/mateus/Github/desafio/edges"))
(def number-of-edges (count readstuff))

(def mini-edges (drop 940 readstuff))
(first (first readstuff))
(last (first readstuff))

(def graph {})
;; add edges to the graph in the form of {:1 #{:2 -}} a map of sets
;;steps: see if node is in the map, if yes addneighbor, if not add node then add neighbor


(if (contains? graph (keyword (first workingedge)))
  (merge-with clojure.set/union graph {:20 #{42}})
  (merge-with clojure.set/union graph {:20 #{42}}))

(def iterategraph
(loop [iteration 0]
  (def workingedge (nth mini-edges iteration))
  (merge-with clojure.set/union graph {(keyword (first workingedge)) #{(read-string (last workingedge))}})
  (merge-with clojure.set/union graph {(keyword (last workingedge)) #{(read-string (first workingedge))}})
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration)))))

;; This adds the neighbor the node in the graph
(merge-with clojure.set/union {:1 #{"c"}, :2 #{"ae"}} {:1 #{"b"}})


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

;;(get {:1 #{:1 :2 :3}} :1)
