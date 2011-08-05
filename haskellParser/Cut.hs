module Cut where

import Company

cut :: Company -> Company
cut (n,ds) = (n,map dept ds)
 where
  dept :: Department -> Department
  dept (Department n m sus) = Department n (employee m) (map subunit sus)
  employee :: Employee -> Employee
  employee (Employee n a s m) = Employee n a (s/2) m
  subunit :: SubUnit -> SubUnit
  subunit (EUnit e) = EUnit (employee e)
  subunit (DUnit d) = DUnit (dept d)
