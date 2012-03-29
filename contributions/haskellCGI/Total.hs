module Total where

import Company
import Focus

totalCompany :: Company -> Float
totalCompany (Company _ depts) = sum $ map totalDept depts 
totalDept :: Department -> Float
totalDept (Department _ m dus eus) = sum [totalEmployee m, sum $ map totalDept dus, sum $ map totalEmployee eus]
totalEmployee :: Employee -> Float
totalEmployee (Employee _ _ s) = s

total :: Focus -> Company -> Float
total f@CompanyFocus = totalCompany.readCompany f
total f@(DeptFocus _) = totalDept.readDepartment f 
total f@(EmployeeFocus _ _) = totalEmployee.readEmployee f
total f@(ManagerFocus _) = totalEmployee.readManager f

                                                 