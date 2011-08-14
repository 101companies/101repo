module Cut where

import Company

cut :: Company -> Company
cut (Company n depts) = Company n $ map dept depts
 where
  dept :: Department -> Department
  dept (Department n m sus) = Department n (employee m) (map subunit sus)
  employee :: Employee -> Employee
  employee (Employee n a s) = Employee n a (s/2)  
  subunit :: SubUnit -> SubUnit
  subunit (EUnit e) = EUnit (employee e)
  subunit (DUnit d) = DUnit (dept d)
