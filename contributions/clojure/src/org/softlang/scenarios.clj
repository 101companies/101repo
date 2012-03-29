(ns org.softlang.scenarios
  (:require org.softlang.company)
  (:import (org.softlang.company Dept Company Employee)))

;; cut

(defn cutEmployee [e]
  (update-in e [:salary] (partial * 0.5)))

(defn cutDept [d]
  (update-in
    (update-in 
      (update-in 
        d 
	      [:manager] 
	      cutEmployee)
	    [:employees] 
	    (partial map cutEmployee))
    [:subdepts]
    (partial map cutDept)))

(defn cutCompany [c]
  (update-in c [:depts] (partial map cutDept)))

;; total

(defn totalEmployee [e]
  (:salary e))

(defn totalDept [d]
  (+ (totalEmployee (:manager d)) 
     (reduce + (map totalEmployee (:employees d)))
     (reduce + (map totalDept (:subdepts d)))))

(defn totalCompany [c]
  (reduce + (map totalDept (:depts c))))

