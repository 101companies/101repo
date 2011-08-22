module Binder where

import qualified Data.Text    as T
import Text.Templating.Heist  (TemplateState, bindString, bindSplice)                               
import qualified Text.XmlHtml as X                               
                              

import Company
import API
import Total
import Validators
import Types

focus2view CompanyFocus = "Company"
focus2view (DeptFocus _) = "Department"
focus2view (EmployeeFocus _ _) = "Employee"
focus2view (ManagerFocus _) = "Employee" 

-- create options splice for every focus (given by the 'list' argument) 
optionNodes :: Company -> (Focus -> Company -> [Focus]) -> (Focus -> Company -> a) -> (a -> String) -> Focus -> [X.Node] 
optionNodes c list readA nameA f = 
      map (\f' -> X.Element (T.pack "option") [(T.pack "value",T.pack $ show f')] [X.TextNode $ T.pack $ nameA $ readA f' c]) fs
    where 
      fs = list f c      
      
-- create options splice for root departments                                    
deptsSplice c f = return $ optionNodes c deptsFocusList readDepartment getDName f 

-- create options splice for subdepartments of a given (by focus) department
subDeptSplice c f = return $ optionNodes c dusFocusList readDepartment getDName f

-- same for employees
employeesSplice c f = return $ optionNodes c eusFocusList readEmployee getEName f     
                                  

eNamesBinder :: Monad m => [(ENames,String)] -> (TemplateState m -> TemplateState m)
eNamesBinder ens = 
      (bindSplice (T.pack "nameEs") (return $ errorList $ eFilter NameE ens)) .
      (bindSplice (T.pack "addressEs") (return $ errorList $ eFilter AddressE ens)) .
      (bindSplice (T.pack "salaryEs") (return $ errorList $ eFilter SalaryE ens))  
      where
        errorList :: [String] -> [X.Node]
        errorList eStrings = [X.Element (T.pack "ul") [] $ map (\eString -> X.Element (T.pack "li") [] [X.TextNode $ T.pack $ eString]) eStrings]
        eFilter ::  EName -> [(ENames,String)] -> [String] 
        eFilter eName ens =  map snd $ filter ((elem eName).fst) ens   

-- views return template state transforms, one per company data type
companyBinder :: Monad m => Focus -> Company -> (TemplateState m -> TemplateState m)
companyBinder f co =   
    (bindString (T.pack "name") ((T.pack.getCName) c)) . 
    (bindString (T.pack "focus") ((T.pack.show) f)) .
    (bindSplice (T.pack "depts") (deptsSplice c CompanyFocus)) .
    (bindString (T.pack "total") ((T.pack.show.totalCompany) c)) 
      where
        c = readCompany f co
                  

departmentBinder :: Monad m => Focus -> Company -> (TemplateState m -> TemplateState m)
departmentBinder f co = 
    (bindString (T.pack "name") ((T.pack.getDName) d)) .
    (bindString (T.pack "focus") ((T.pack.show) f)) .
    (bindString (T.pack "upperfocus") ((T.pack.show) upperf)) .
    (bindString (T.pack "upperview") ((T.pack.focus2view) upperf)) .
    (bindString (T.pack "mname") ((T.pack.getEName.getManager) d)) .
    (bindString (T.pack "mfocus") ((T.pack.show) $ managerFocus f co)) .
    (bindSplice (T.pack "subdepts") (subDeptSplice co f)) .
    (bindSplice (T.pack "employees") (employeesSplice co f)) .
    (bindString (T.pack "total") ((T.pack.show.totalDept) d))
      where
        d = readDepartment f co
        upperf = upperFocus f

employeeBinder :: Monad m => Focus -> Company -> (TemplateState m -> TemplateState m)
employeeBinder f co =
     (bindString (T.pack "name") ((T.pack.getEName) e)) .
     (bindString (T.pack "focus") ((T.pack.show) f)) .
     (bindString (T.pack "upperfocus") ((T.pack.show) upperf)) .
     (bindString (T.pack "upperview") ((T.pack.focus2view) upperf)) .
     (bindString (T.pack "address") ((T.pack.getAddress) e)) .
     (bindString (T.pack "salary") ((T.pack.show.getSalary) e))
        where
          e = readEM f co
          upperf = upperFocus f           