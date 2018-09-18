(ns sicp.ch1_1_8 (:require [clojure.test :refer [is]]))

;;; Exercise 1.8

(defn abs [n] (max n (- n)))

(defn square [x] (* x x))

(defn average [x y]
  (/ (+ x y) 2))

; the previous improve function
(defn improve [guess x]
  (average guess (/ x guess)))

; a better improve function
(defn better-improve [guess x]
  (/
    (+
      (* 2 guess)
      (/ x (square guess)))
    3))


(defn good-enough? [guess previous-guess]
  (< (abs (- guess previous-guess)) 0.001))

(defn sqrt-iter [guess previous-guess x]
  (if (good-enough? guess previous-guess)
    guess
    (sqrt-iter (better-improve guess x) guess x)))

(defn sqrt [x]
  (sqrt-iter 1.0 0 x))

(println (sqrt 0.001))
(println (sqrt 9999999999998))