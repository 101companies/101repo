module Cut where

import Company

cut :: Company -> Company
cut (n,ds) = (n,map dept ds)
 where
  dept :: Dept -> Dept
  dept (Dept n m sus) = Dept n (employee m) (map subunit sus)
  employee :: Employee -> Employee
  employee (Employee n a s) = Employee n a (s/2)  
  subunit :: SubUnit -> SubUnit
  subunit (PU e) = PU (employee e)
  subunit (DU d) = DU (dept d)
