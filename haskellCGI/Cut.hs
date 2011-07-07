module Cut where

import Company
import API

cutCompany :: Company -> Company
cutCompany (Company name depts) = Company name $ map cutDept depts
cutDept :: Department -> Department
cutDept (Department n m dus eus) = Department n (cutEmployee m) (map cutDept dus) (map cutEmployee eus)
cutEmployee :: Employee -> Employee
cutEmployee (Employee n a s) = Employee n a (s/2)  

cut :: Focus -> Company -> Company
cut f@CompanyFocus = readCutWrite cutCompany f  
cut f@(DeptFocus _) = readCutWrite cutDept f 
cut f@(EmployeeFocus _ _) = readCutWrite cutEmployee f 
cut f@(ManagerFocus _) = readCutWrite cutEmployee f

readCutWrite :: (Readable a, Writeable a) => (a -> a) -> Focus -> Company -> Company
readCutWrite cu f co = (writeA f co) (cu $ readA f co)  
