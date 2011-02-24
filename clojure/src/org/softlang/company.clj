(ns org.softlang.company)

(defrecord Employee [ename address salary])
(defrecord Dept [dname manager employees subdepts])
(defrecord Company [cname depts])