(ns sicp.ch1_1_4 (:require [clojure.test :refer [is]]))

;;; Exercise 1.4

; The first condition determines the operator for the function body to use
; addition if b is positive, substraction if negative. This way, the function
; always add the absolute of b to a
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(is (= 5 (a-plus-abs-b 2 3)))
(is (= 5 (a-plus-abs-b 2 -3)))
(is (= 1 (a-plus-abs-b -2 -3)))