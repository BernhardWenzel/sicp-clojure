(ns sicp.ch01 (:use clojure.test))

(def expression
  (/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
    (* 3 (- 6 2) (- 2 7))))

(deftest test-expression
  (is (= -37/150 expression)))

(run-tests)