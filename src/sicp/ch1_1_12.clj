(ns sicp.ch1-1-12)

;;; Exercise 1.12

(defn p [row col]
  (if (or (= row 0) (= row 1) (= col 0) (= col row)) 1
    (+ (p (dec row) (dec col))
       (p (dec row) col))))


(defn print-triangle [rows]
  (for [row (range rows)
        col (range (inc row))]
    (do
      (print (str (p row col) " "))
      (if (= row col) (println)))))

(print-triangle 10)