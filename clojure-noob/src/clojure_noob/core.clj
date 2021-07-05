(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn multi-arity
  "This is how you do overloading"
  ;; 3 arity
  ([first second third]
   (println first second third))
  ;; 2 arity
  ([first second]
   (println first second))
  ;; 1 arity
  ([first]
   (println first)))

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(defn my-first
  "Destructure args"
  ([[first]] ; first is within a vector
   first)
  ([{lat :lat lng :lng}]
   (println (str "Treasure lat: " lat))
   (println (str "Treasure lng: " lng))))

(defn recursive-printer
  ([]
   (recursive-printer 0))
  ([iteration]
   (println iteration)
   (if (> iteration 3)
     (println "Goodbye")
     (recursive-printer (inc iteration)))))

(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))
