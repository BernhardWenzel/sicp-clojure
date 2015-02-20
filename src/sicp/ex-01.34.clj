(ns sicp (:use clojure.test))

(defn f [g] (g 2))

(defn square [x] (* x x))

(= 4 (f square))
(f f)

(run-tests)
