module Validators where

import Data.Maybe

import Company
import API
import Utils
import Types

-- applying many validations by means of doing all validations 
validations :: [Validation a] -> Validations a
validations vs c f a = if all isNothing results 
                      then Nothing
                      else Just $ catMaybes results 
                    where
                      results = [v c f a | v <- vs] 

-- company validations (no validations)
validateCompany :: Validations Company
validateCompany _ _ _ = Nothing

-- department validations
validateDept :: Validations Department
validateDept c f (Department n m dus eus) = validateDName c f n 
                       
-- department name validations
validateDName :: Validations String                      
validateDName = validations [deptUniqueness]

-- department names are unique within a company 
deptUniqueness :: Validation String
deptUniqueness c f name = if (name /= oldName) && name `elem ` (map getDName (flattenDeptsC c))
                          then Just $ ([NameE],
                            "\"" ++ name ++  "\" " 
                            ++ "already used as department name.")
                          else Nothing
                            where
                              oldName = getDName $ readDepartment f c
-- employee validations
validateEmployee :: Validations Employee
validateEmployee c f (Employee n a s) = if null vs 
                            then Nothing
                            else Just $ concat vs 
                              where 
                                vs = catMaybes [validateNA c f (n,a), validateSalary c f s]
                  
                       
                                                                              
-- employee name/address validations
validateNA :: Validations (String, String)          
validateNA = validations [employeeUniqueness]

-- name/address pairs are unique within a company
employeeUniqueness :: Validation (String, String)
employeeUniqueness c f nd@(n,a) = if (nd /= oldnd) && nd `elem` (map (\e -> (getEName e, getAddress e)) (flattenEmployeesC c)) 
                            then Just $ ([NameE,AddressE],
                              "Name/Address - combination \"" ++ n ++ "\"/\"" ++ a ++"\" " 
                              ++ "already used.")
                            else Nothing
                              where
                                  oldnd = (getName $ readEM f c, getAddress $ readEM f c)

-- salary validators 
validateSalary :: Validations Float
validateSalary = validations [managerMaxSalary, salaryPositive]                              
                          
-- an employee as a lower salary than his/her manager
managerMaxSalary :: Validation Float
managerMaxSalary c f@(EmployeeFocus _ _) s = if not (s < ms)
                            then Just $ ([SalaryE],
                              "Salary must be less than this employee's manager's salary (" ++ show ms ++ " $) .")
                            else Nothing
                              where
                                ms = getSalary $ getManager $ readDepartment (upperFocus f) c
                                
managerMaxSalary c f@(ManagerFocus _) s = if any (>=s) ss
                            then Just $ ([SalaryE],
                              "This manager's salary must be greater than all employees'. Greater than " ++ show (maximum ss) ++ " $.")
                            else Nothing
                              where ss = (map getSalary $ getEus $ readDepartment (upperFocus f) c)
                              
-- a salary must be positive 
salaryPositive :: Validation Float                             
salaryPositive _ _ s = if s <= 0
                    then Just ([SalaryE],
                      "A salary must be postive.")
                    else Nothing
                                              