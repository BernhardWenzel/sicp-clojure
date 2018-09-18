(ns sicp.ch1_1_7 (:require [clojure.test :refer [is]]))

;;; Exercise 1.7

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn abs [n] (max n (- n)))

(defn square [x] (* x x))

(defn good-enough? [guess previous-guess]
  (< (abs (- guess previous-guess)) 0.001))

(defn sqrt-iter [guess previous-guess x]
  (if (good-enough? guess previous-guess)
    guess
    (sqrt-iter (improve guess x) guess x)))

(defn sqrt [x]
  (sqrt-iter 1.0 0 x))

(println (sqrt 0.001))
(println (sqrt 9999999999998)) ; thanks to http://www.billthelizard.com/2009/10/sicp-exercises-16-18.html found this value
