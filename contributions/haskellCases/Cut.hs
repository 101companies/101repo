module Cut where

import Company

cut :: Company -> Company
cut (Company n ds) = Company n (map dep ds)
 where
  dep :: Department -> Department
  dep (Department n m sus)
   = Department n (emp m) (map subunit sus)
   where
    emp :: Employee -> Employee
    emp (Employee n a s) = Employee n a (s/2)  
    subunit :: SubUnit -> SubUnit
    subunit (EUnit e) = EUnit (emp e)
    subunit (DUnit d) = DUnit (dep d)
