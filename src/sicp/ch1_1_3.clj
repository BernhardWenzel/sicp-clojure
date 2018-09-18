(ns sicp.ch1_1_3 (:require [clojure.test :refer [is]]))

;;; Exercise 1.3

(defn max-two [a b c]
  (cond (and (< c a) (< c b)) [a b]
        (and (< a c) (< a b)) [b c]
        :else [a c]))

(defn square [x]
  (* x x))

(defn sum-square-of-max [a b c]
  (apply + (map square (max-two a b c))))

(is (= 13 (sum-square-of-max 1 2 3)))
(is (= 13 (sum-square-of-max 1 3 2)))
(is (= 13 (sum-square-of-max 3 2 1)))
(is (= 13 (sum-square-of-max 3 2 0)))
(is (= 13 (sum-square-of-max 0 2 3)))
(is (= 13 (sum-square-of-max 2 2 3)))
(is (= 8 (sum-square-of-max 2 2 2)))