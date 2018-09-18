(ns sicp.ch1_1_9 (:require [clojure.test :refer [is]]))

;;; Exercise 1.9

(defn + [a b]
  (if (= a 0)
    b
    (inc (+ (dec a) b))))

; recursive process
; (+ 4 5)
; (inc (+ 3 5)
; (inc (inc (+ 2 5))
; (inc (inc (inc (+ 1 5)))
; (inc (inc (inc (inc (+ 0 5))))
; (inc (inc (inc (inc 5)))
; (inc (inc (inc 6))
; (inc (inc 7))
; (inc 8)
; 9
(is (= 9 (+ 4 5)))


; iterative process
; (++ 4 5)
; (++ 3 6)
; (++ 2 7)
; (++ 1 8)
; (++ 0 9)
; 9
(defn ++ [a b]
  (if (= a 0)
    b
    (++ (dec a) (inc b))))

(is (= 9 (++ 4 5)))