(ns sicp (:use clojure.test))

(defn f [g] (g 2))

(defn square [x] (* x x))

(= 4 (f square))


(f f)

; substitutions
; 1. g becomes f
; (f f) => (f 2)
; 2. g becomes 2
; (2 2) => '2' not a function ("java.lang.Long cannot be cast to clojure.lang.IFn")

(run-tests)
