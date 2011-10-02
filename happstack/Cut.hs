module Cut where

import Company
import Focus

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
readCutWrite f@CompanyFocus c   = writeCompany f c $ cutCompany $ readCompany f c
readCutWrite f@(DeptFocus _) c  = writeDepartment f c $ cutDept $ readDepartment f c
readCutWrite f@(EmployeeFocus _ _) c = writeEmployee f c $ cutEmployee $ readEmployee f c
readCutWrite f@(ManagerFocus _) c = writeManager f c $ cutEmployee $ readManager f c 