module Cut where

import Control.Parallel

import Company

cutCompany :: Company -> Company
cutCompany (Company name depts) = Company name $ map cutDept depts

cutDept :: Department -> Department
cutDept (Department n m dus eus) = Department n (cutEmployee m) (map cutDept dus) (map cutEmployee eus)
cutEmployee :: Employee -> Employee
cutEmployee (Employee n a s) = Employee n a (s/2)  
