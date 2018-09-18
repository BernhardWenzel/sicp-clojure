(ns sicp.ch1_1_31 (:require [clojure.test :refer [is]]))

;;; Exercise 1.31

(defn prod [term a next b]
  (if (> a b) 1
      (* (term a)(prod term (next a) next b))))

(defn inc [x]
  (+ x 1))

(defn id[x]
  x)

(defn factorial [x]
  (prod id 1 inc x))

(is(= 1 (factorial 1)))
(is(= 2 (factorial 2)))
(is(= 120 (factorial 5)))
