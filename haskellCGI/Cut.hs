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
readCutWrite f@CompanyFocus = readCutWrite' writeCompany readCompany cutCompany f  
readCutWrite f@(DeptFocus _) = readCutWrite' writeDepartment readDepartment cutDept f 
readCutWrite f@(EmployeeFocus _ _) = readCutWrite' writeEmployee readEmployee cutEmployee f 
readCutWrite f@(ManagerFocus _) = readCutWrite' writeEmployee readEmployee cutEmployee f

readCutWrite' writeA readA cut f co = (writeA f co) (cut $ readA f co)  
