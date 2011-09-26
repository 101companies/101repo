module Cut(cutLogCompany) where

import Control.Monad.Writer

import Company
import Types    

-- cut a company's salaries while logging
cutLogCompany :: Company -> Writer Log Company
cutLogCompany c@(Company name depts) = do
    tell ["Starting cutting Company \"" ++ name ++ "\", old Total = " ++  (show $ totalCompany c)]
    cutDepts <- mapM (cutLogDept 1) depts
    let cutC = Company name cutDepts 
    tell ["Done cutting Company \"" ++ name ++ "\", new Total = " ++ (show $ totalCompany cutC)]
    return cutC
    
cutLogDept :: Int -> Department -> Writer Log Department
cutLogDept n d@(Department name m dus eus) = do
    tell [replicate n '\t' ++ "Starting cutting Department \"" ++ name ++ "\", old Total = " ++ (show $ totalDept d)]
    cutManager <- cutLogEmployee (n + 1) m
    cutDus <- mapM (cutLogDept (n + 1)) dus
    cutEus <- mapM (cutLogEmployee (n + 1)) eus
    let cutD = Department name cutManager cutDus cutEus
    tell [replicate n '\t' ++ "Done cutting Department \"" ++ name ++ "\", new Total = " ++ (show $ totalDept cutD)]
    return cutD

cutLogEmployee :: Int -> Employee -> Writer Log Employee
cutLogEmployee n e@(Employee name address salary) = do
    tell [replicate n '\t' ++ "Starting cutting Employee \"" ++ name ++ "\", old salary = " ++ (show $ totalEmployee e)]
    let cutSalary = salary / 2
    let cutE = Employee name address cutSalary
    tell [replicate n '\t' ++ "Done cutting Employee \"" ++ name ++ "\", new salary = " ++ (show $ totalEmployee cutE)]
    return cutE

 
-- not logging helpers    
totalCompany (Company _ depts) = sum $ map totalDept depts
totalDept (Department _ m dus eus) = sum [
        totalEmployee m, 
        sum $ map totalDept dus, 
        sum $ map totalEmployee eus]
totalEmployee (Employee _ _ s) = s