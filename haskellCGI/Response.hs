module Response where

import Network.CGI
import Text.XHtml
import Control.Monad (liftM)
import Data.Maybe (fromMaybe)      

import Company
import SampleCompany
import API
import Total
import Cut
import CompanyHtml
import Action

readCompanyCookie = liftM (fromMaybe company) $ readCookie "companyCookie"
writeCompanyCookie c = setCookie $ newCookie "companyCookie" $ show c   
 
cgiMain :: CGI CGIResult
cgiMain =  do
            f <- getInput "focus"
            let focusP = maybe CompanyFocus read f
            a <- getInput "action"
            let actionP = maybe View read a
            html <- doAction actionP focusP 
            output . renderHtml . page "101companies WebApp" $ html 
        

-- perform action and return html for next page        
doAction :: Action -> Focus -> CGI Html
doAction View f = do 
    liftM (view f) readCompanyCookie
    
doAction Cut f = do
    c <- readCompanyCookie
    let cutC = cut f c   
    writeCompanyCookie cutC
    return $ view f cutC
        
                                                    
doAction Save f@(DeptFocus _) = doSaveAction f dSave

doAction Save f@CompanyFocus = doSaveAction f cSave

doAction Save f@(EmployeeFocus _ _) = doSaveAction f eSave

doAction Save f@(ManagerFocus _) = doSaveAction f eSave
 

doSaveAction :: Focus -> (Focus -> CGIT IO Company) -> CGI Html
doSaveAction f e = do
    newCompany <- e f
    return $ view f newCompany  


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
       
    

-- plain view
view :: Focus -> Company -> Html
view f@CompanyFocus = companyHtml f
view f@(DeptFocus _) = deptHtml f
view f@(EmployeeFocus _ _) = employeeHtml f
view f@(ManagerFocus _) = employeeHtml f                