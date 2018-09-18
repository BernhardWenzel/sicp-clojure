(ns sicp.ch1_1_2 (:require [clojure.test :refer [is]]))

(def expression
  (/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
    (* 3 (- 6 2) (- 2 7))))

(is (= -37/150 expression))