module Save where

import Network.CGI
import Control.Monad (liftM)
import Data.Maybe (fromMaybe) 

import Company  
import SampleCompany
import API

-- try to read cookie or return default company
readCompanyCookie = liftM (fromMaybe company) $ readCookie "companyCookie"
-- write cookie
writeCompanyCookie c = setCookie $ newCookie "companyCookie" $ show c   

-- process company edit
cSave :: Focus -> CGIT IO Company
cSave f = do
    c <- readCompanyCookie
    n <- getInput "name"
    let name = fromMaybe (getCName $ readCompany f c) n
    let newCompany = readSetWrite (flip setCName name) f c
    writeCompanyCookie newCompany
    return newCompany   


-- process department edit
dSave :: Focus -> CGIT IO Company
dSave f = do 
    c <- readCompanyCookie
    n <- getInput "name"
    let name = fromMaybe (getDName $ readDepartment f c) n
    let newCompany = readSetWrite (flip setDName name) f c 
    writeCompanyCookie newCompany
    return newCompany     
    
-- process employee edit
eSave :: Focus -> CGIT IO Company
eSave f = do
    c <- readCompanyCookie
    let e = readIt f c
    n <- getInput "name"
    let name = fromMaybe (getEName e) n
    a <- getInput "address"
    let address = fromMaybe (getAddress e) a
    s <- getInput "salary"
    let salary = read $ fromMaybe (show $ getSalary e) s  :: Float
    let newCompany = readSetWrite ((flip setEName name).(flip setAddress address).(flip setSalary salary)) f c
    writeCompanyCookie newCompany
    return newCompany
        where
            readIt = case f of
                (EmployeeFocus _ _) -> readEmployee
                (ManagerFocus _) -> readManager
