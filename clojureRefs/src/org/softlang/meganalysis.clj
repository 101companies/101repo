(ns org.softlang.meganalysis
  (:require org.softlang.company)
  (:use org.softlang.scenarios)
  (:import (org.softlang.company Dept Company Employee)))

;; sample company

(def meganalysis (ref 
                   (Company. "meganalysis" 
                             [(ref 
                                (Dept. "Research" 
                                     (Employee. "Craig" "Redmond" 123456) 
                                     [(Employee. "Erik" "Utrecht" 12345) 
                                      (Employee. "Ralf" "Koblenz" 1234)]
                                     []))
                              (ref
                                (Dept. "Development"
                                     (Employee. "Ray" "Redmond" 234567)
                                     []
                                     [(ref
                                        (Dept. "Dev1"
                                             (Employee. "Klaus" "Boston" 23456)
                                             []
                                             [(ref (Dept. "Dev11"
                                                     (Employee. "Karl" "Riga" 2345)
                                                     [(Employee. "Joe" "Wifi City" 2344)]
                                                     []))]))]))])))
