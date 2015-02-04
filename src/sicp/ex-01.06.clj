(ns sicp (:use clojure.test))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn abs [n] (max n (- n)))

(defn square [x] (* x x))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn new-if [predicate then-clause else-clause]
  (cond (predicate) then-clause
        :else else-clause))

; The problem with the new-if function shows up here:
; (new-if A B C) gets application-order evaluated, meaning at first all
; arguments A B C are evaluated and then substituted by the "new-if" function.
; Therefore the else-clause (argument C) always gets evaluated. That leads to endless recursion
; The Clojure if function is a special form that behaves differently and only evaluates an argument if the
; condition is met
(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)  ; <= replace with "if" to make it work
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(is (and (> 3.001 (sqrt 9)) (< 2.999 (sqrt 9))))

(run-tests)