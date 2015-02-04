(ns sicp)

; recursive call of function p => never finishes
(defn p [] (p))

(defn test [x y]
  (if (= x 0) 0 y))

; applicative order: evaluates (p) first => stackoverflow
(test 0 (p))

