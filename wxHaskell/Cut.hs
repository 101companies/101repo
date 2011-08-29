module Cut where

import Company
import API

cutCompany :: Company -> Company
cutCompany (Company n depts) = Company n $ map cutDept depts

cutDept :: Department -> Department
cutDept (Department n m dus eus) = Department n 
                                    (cutEmployee m) 
                                    (map cutDept dus) 
                                    (map cutEmployee eus)

cutEmployee :: Employee -> Employee
cutEmployee (Employee n a s) = Employee n a (s/2)  

readCutWrite :: Focus -> Company -> Company
readCutWrite f@CompanyFocus = readCutWrite' cutCompany f  
readCutWrite f@(DeptFocus _) = readCutWrite' cutDept f 
readCutWrite f@(EmployeeFocus _ _) = readCutWrite' cutEmployee f 
readCutWrite f@(ManagerFocus _) = readCutWrite' cutEmployee f

readCutWrite' :: (Readable a, Writeable a) => (a -> a) -> Focus -> Company -> Company
readCutWrite' cu f co = (writeA f co) (cu $ readA f co)  
