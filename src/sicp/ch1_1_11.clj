(ns sicp.ch1_1_11 (:require [clojure.test :refer [is]]))

;;; Exercise 1.11
; recursive case is straight forward from the function def:
(defn f [n]
  (if (< n 3) n
    (+ (f (- n 1)) (* 2 (f (- n 2))) (* 3 (f (- n 3))))))

(is (= 0 (f 0)))
(is (= 1 (f 1)))
(is (= 2 (f 2)))
(is (= 4 (f 3)))
(is (= 11 (f 4)))
(is (= 25 (f 5)))
(is (= 59 (f 6)))


; iteration case: have a look at the first few iterations
; f(0)  = 0
; f(1)  = 1
; f(2)  = 2
; f(3)  = f(2) + 2f(1) + 3f(0)
;       =   2  + 2*1   + 3*0
;       = 4
; f(4)  = f(3) + 2f(2) + 3f(1)
;       =  4   + 2*2   + 3*1
;       = 11
; if we write the three summands as:
;       = a + b + c
; we notice that in each iteration following substitions happen:
; a = f(a)
; b = a
; c = b
; so all we have to do is start the iteration with the correct values for n = 3
; which are a = 2, b = 1, c = 0
; and iterate until n < 3 and the result is stored in a
(defn f-iter [a b c step]
  (if (< step 3) a
      (f-iter (+ a (* 2 b) (* 3 c)) a b (- step 1))))

(defn fi [n]
  (if (< n 3) n
      (f-iter 2 1 0 n)))

(is (= 0 (fi 0)))
(is (= 1 (fi 1)))
(is (= 2 (fi 2)))
(is (= 4 (fi 3)))
(is (= 11 (fi 4)))
(is (= 25 (fi 5)))
(is (= 59 (fi 6)))