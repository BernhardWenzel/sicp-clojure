(ns sicp (:use clojure.test))

(defn accumulate-iter [combiner null-value term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (combiner (term a) result))))
  (iter a null-value))

(defn prod [term a next b]
  (accumulate-iter * 1 term a next b))

(defn inc [x]
  (+ x 1))

(defn id[x]
  x)

(defn factorial [x]
  (prod id 1 inc x))

(is(= 1 (factorial 1)))
(is(= 2 (factorial 2)))
(is(= 120 (factorial 5)))

(defn sum [term a next b]
  (accumulate-iter + 0 term a next b))

(defn cube [x]
  (* x x x))

(defn integral [f a b dx]
  (defn add-dx [x]
    (+ x dx))
  (* (sum f (+ a (/ dx 2.0)) add-dx b) dx))

(is (= 0.24998750000000042 (integral cube 0 1 0.01)))

