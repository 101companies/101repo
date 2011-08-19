(ns org.softlang.scenarios
  (:require org.softlang.company)
  (:import (org.softlang.company Dept Company Employee)))

;; cut

(defn cutEmployee [e]
  ;
  (update-in e [:salary] (partial * 0.5)))

(defn cutDept [d]
  (dosync
		(alter d #(update-in % [:manager] cutEmployee))
		(alter d #(update-in % [:employees] (partial map cutEmployee)))
		(alter d #(update-in % [:subdepts] (partial map cutDept))))
  ;; returning changed ref
  d)

(defn cutCompany [c]
  (dosync
    (alter c #(update-in % [:depts] (partial map cutDept))))
  ;; returning changed ref
  c)

;; total

(defn totalEmployee [e]
  (:salary e))

(defn totalDept [d]
  (dosync
    (+ (totalEmployee (:manager @d)) 
       (reduce + (map totalEmployee (:employees @d)))
       (reduce + (map totalDept (:subdepts @d))))))

(defn totalCompany [c]
  (dosync
    (reduce + (map totalDept (:depts @c)))))
