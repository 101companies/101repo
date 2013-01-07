module Cut where

import Company

cut :: Company -> Company
cut (Company n ds) = Company n (map dep ds)
  where
   dep :: Department -> Department
   dep (Department n m ds es)
     = Department n (emp m) (map dep ds) (map emp es)
     where
       emp :: Employee -> Employee
       emp (Employee n a s) = Employee n a (s/2)  
