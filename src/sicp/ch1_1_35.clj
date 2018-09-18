(ns sicp.ch1_1_35
  (:require [clojure.test]
            [clojure.test :refer [is]]))

;;; Exercise 1.35

(defn abs [n] (max n (- n)))

(defn close-enough? [x y]
  (< (abs (- x y)) 0.001))

(defn average [x y]
  (/ (+ x y) 2.0))

(defn search [f neg-point pos-point]
  (let [midpoint (average neg-point pos-point)]
    (if
      (close-enough? neg-point pos-point)
      midpoint
      (let [test-value (f midpoint)]
        (cond
          (pos? test-value)
          (search f neg-point midpoint)
          (neg? test-value)
          (search f midpoint pos-point)
          :else midpoint)))))

(defn half-interval-method [f a b]
  (let [a-value (f a), b-value (f b)]
    (cond
      (and (neg? a-value) (pos? b-value))
      (search f a b)
      (and (neg? b-value) (pos? a-value))
      (search f b a)
      :else
      (throw (Exception. (str ("Values are not of opposite sign" a b)))))))

(defn sinus [x]
  (Math/sin x))

(is (= 3.14111328125 (half-interval-method sinus 2.0 4.0)))

;; The exercise starts here
(def tolerance 0.00001)

(defn fixed-point [f first-guess]
  (letfn [(close-enough? [x y]
            (< (abs (- x y)) tolerance))
          (fp-try [guess]
            (let [next (f guess)]
              (if (close-enough? guess next) next
                (fp-try next))))]
    (fp-try first-guess)))

(is (= 1.6180327868852458 (fixed-point (fn [x] (+ 1.0 (/ 1.0 x))) 1.0)))