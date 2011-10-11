module Save where

import Network.CGI
import Control.Monad (liftM)
import Data.Maybe (fromMaybe) 

import Company  
import SampleCompany
import Focus

-- try to read cookie or return default company
tryReadCCookie = liftM (fromMaybe company) $ 
                 readCookie "companyCookie"
-- write cookie
writeCCookie s = setCookie $ 
                 newCookie "companyCookie" $ 
                 show s   

-- process company edit
cSave :: Focus -> CGIT IO Company
cSave f = do
    c <- tryReadCCookie
    n <- getInput "name"
    let name = fromMaybe (cname $ readCompany f c) n
    let newCompany = writeCompany f c (Company name (depts c)) 
    writeCCookie newCompany
    return newCompany   


-- process department edit
dSave :: Focus -> CGIT IO Company
dSave f = do 
    c <- tryReadCCookie
    let oldDept = readDepartment f c
    n <- getInput "name"
    let name = fromMaybe (dname oldDept) n
    let newCompany = writeDepartment f c (Department name (manager oldDept) (dus oldDept) (eus oldDept))
    writeCCookie newCompany
    return newCompany     
    
-- process employee edit
eSave :: Focus -> CGIT IO Company
eSave f = do
    c <- tryReadCCookie
    let oldEmployee = readEmployee f c 
    n <- getInput "name"
    let newName = fromMaybe (ename oldEmployee) n
    a <- getInput "address"
    let newAddress = fromMaybe (address oldEmployee) a
    s <- getInput "salary"
    let newSalary = read $ fromMaybe (show $ salary oldEmployee) s  :: Float
    let oldEmployee = readEmployee f c
    let newCompany = writeEmployee f c (Employee newName newAddress newSalary)
    writeCCookie newCompany
    return newCompany
