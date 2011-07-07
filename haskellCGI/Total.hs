module Total where

import Company
import API

totalCompany :: Company -> Float
totalCompany (Company _ depts) = sum $ map totalDept depts 
totalDept :: Department -> Float
totalDept (Department _ m dus eus) = sum [totalEmployee m, sum $ map totalDept dus, sum $ map totalEmployee eus]
totalEmployee :: Employee -> Float
totalEmployee (Employee _ _ s) = s

total :: Focus -> Company -> Float
total f@CompanyFocus = readTotal totalCompany f
total f@(DeptFocus _) = readTotal totalDept f
total f@(EmployeeFocus _ _) = readTotal totalEmployee f
total f@(ManagerFocus _) = readTotal totalEmployee f

readTotal :: (Readable a, Writeable a) => (a -> Float) -> Focus -> Company -> Float
readTotal t f c = t $ readA f c

                                                 