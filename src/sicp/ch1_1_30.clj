(ns sicp.ch1_1_30 (:require [clojure.test :refer [is]]))

;;; Exercise 1.30

; iterative sum
(defn sum [term a next b]
  (letfn [(iter [a result]
            (if (> a b)
              result
              (iter (next a) (+ (term a) result))))]
    (iter a 0)))

;;; same as 1.29

(defn cube [x]
  (* x x x))

(defn integral [f a b dx]
  (letfn [(add-dx [x]
            (+ x dx))]
    (* (sum f (+ a (/ dx 2.0)) add-dx b) dx)))

(println (integral cube 0 1 0.01))

(defn simp [f a b n]
  (let [h (/ (- b a) n)]
    (letfn [(y [k] (f (+ a (* k h))))
            (term [k]
              (* (cond
                   (or (= k 0) (= k n)) 1
                   (even? k) 2
                   :else 4)
                 (y k)))]
      (* (/ h 3) (sum term 0 inc n)))))

(println (simp cube 0.0 1.0 100))
(println (simp cube 0.0 1.0 1000))