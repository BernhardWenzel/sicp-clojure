(ns sicp.ch1_1_10 (:require [clojure.test :refer [is]]))

;;; Exercise 1.10

(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1) (A x (- y 1)))))

; (A 1 10)
; (A 0 (A 1 9))
; (A 0 (A 0 (A 1 8)))
; (A 0 (A 0 (A 0 (A 1 7)))
; ...
; (* 2 y (* 2 y (* 2 y ... n times ))

(is (= 1024 (A 1 10)))
(is (= 65536 (A 2 4)))
(is (= 65536 (A 3 3)))

; (A 0 n)
; (* 2 n)
(defn f [n]
  (A 0 n))
(is (= 4 (f 2)))
(is (= 6 (f 3)))
(is (= 8 (f 4)))

; (A 1 n)
; (A 1 (A (- n 1) (A 1 (- n 1)))
; (A 1 (A (- n 1) (A 1 (- n 1)))
; 2^n
(defn g [n]
  (A 1 n))
(is (= 4 (g 2)))
(is (= 8 (g 3)))
(is (= 16 (g 4)))

; (A 2 n)
; (A 0 (A (- n 1) (A 1 (- n 1)))
; ? not sure ...
(defn h [n]
  (A 2 n))
(is (= 4 (h 2)))
(is (= 16 (h 3)))
(is (= 65536 (h 4)))