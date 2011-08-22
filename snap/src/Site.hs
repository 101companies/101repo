{-# LANGUAGE OverloadedStrings #-}

module Site
  ( site
  ) where

import           Control.Applicative
import           Data.Maybe
import qualified Data.Text.Encoding as E
import qualified Data.Text as T
import qualified Text.XmlHtml as X
import qualified Data.ByteString.Char8 as B
import           Snap.Extension.Heist
import           Snap.Util.FileServe
import           Snap.Types
import           Text.Templating.Heist

import           Application
import           Company  
import           SampleCompany
import           Total
import           API

-- runs all given actions on a TemplateState
heistLocals :: MonadHeist n m => m a -> [TemplateState n -> TemplateState n] -> m a
heistLocals = foldl (flip $ heistLocal)

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


-- helper to decode parameters
decodedParam p = fromMaybe "" <$> getParam p
 
-- get view name by focus
focus2view CompanyFocus = "Company"
focus2view (DeptFocus _) = "Department"
focus2view (EmployeeFocus _ _) = "Employee"
focus2view (ManagerFocus _) = "Employee" 
 
-- handler for company pages
viewCompany :: Application ()
viewCompany = do
    heistLocals (render "company")  
                [ (bindString "name" ((T.pack.getCName) company))
                 ,(bindSplice "depts" (deptsSplice company CompanyFocus))
                 ,(bindString "total" ((T.pack.show.totalCompany) company))]
                
-- handler for department pages
viewDepartment :: Application ()
viewDepartment = do
    focusP <- decodedParam "focus"
    let focus = read $ B.unpack $ focusP
    let upperfocus = upperFocus focus
    let department = readDepartment focus company
    heistLocals (render "department")
                [ (bindString "name" ((T.pack.getDName) department))
                 ,(bindString "upperfocus" ((T.pack.show) upperfocus))
                 ,(bindString "upperview" ((T.pack.focus2view) upperfocus)) 
                 ,(bindString "mname" ((T.pack.getEName.getManager) department))
                 ,(bindString "mfocus" ((T.pack.show) $ managerFocus focus company))
                 ,(bindSplice "subdepts" (subDeptSplice company focus))
                 ,(bindSplice "employees" (employeesSplice company focus))
                 ,(bindString "total" ((T.pack.show.totalDept) department))]
                 
-- handler for employee pages
viewEmployee :: Application ()
viewEmployee = do
    focusP <- decodedParam "focus"
    let focus = read $ B.unpack $ focusP
    let upperfocus = upperFocus focus 
    let employee = readEM focus company
    heistLocals (render "employee")
                [ (bindString "name" ((T.pack.getEName) employee))
                 ,(bindString "upperfocus" ((T.pack.show) upperfocus))
                 ,(bindString "upperview" ((T.pack.focus2view) upperfocus)) 
                 ,(bindString "address" ((T.pack.getAddress) employee))
                 ,(bindString "salary" ((T.pack.show.getSalary) employee))]
           

-- routing table    
site :: Application ()
site = route [ ("/Company/View/", viewCompany)
              ,("/Department/View/:focus", viewDepartment)
              ,("/Employee/View/:focus", viewEmployee)]
       <|> serveDirectory "resources/static"
