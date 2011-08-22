{-# LANGUAGE OverloadedStrings #-}

module Serverparts where

import Control.Monad (msum)
import qualified Data.ByteString.Char8 as B
import Happstack.Server (CookieLife(Session), ServerPart, 
                         addCookie, mkCookie, readCookieValue)
import Text.Templating.Heist.TemplateDirectory
import Happstack.Server.Internal.Types
import Happstack.Server.Internal.Monads
import Happstack.Server.Heist (render)
import Text.Templating.Heist  (emptyTemplateState)                           
                               

import Company
import SampleCompany
import API
import Cut
import Binder
import Types
import Save
import Validators


-- respond based on action
mainPart :: Action -> View -> Focus -> ServerPartT IO Response
mainPart View = viewPart
mainPart Cut  = cutPart
mainPart Save = savePart   


-- respond to a view request by diplaying a company from a cookie 
-- the default company
viewPart :: View -> Focus -> ServerPartT IO Response
viewPart v f = do 
  msum 
    [ do
        c <- readCCookie
        displayPart v f c []
    , do
        addCookie Session (mkCookie "company" (show company))
        displayPart v f company []
    ]

-- respond to a cut request by cutting and displaying    
cutPart :: View -> Focus -> ServerPartT IO Response 
cutPart v f = do
  c <- readCCookie
  let cutc = readCutWrite f c
  addCookie Session (mkCookie "company" (show cutc))
  displayPart v f cutc []

-- respond to a save request by saving new data in the client's cookie  
savePart :: View -> Focus -> ServerPartT IO Response
savePart v f = do
  c <- readCCookie
  s <- save
  case s of
    (Left errs) -> displayPart v f c errs
    (Right newc) -> displayPart v f newc []       
    where
      save = case v of
        CompanyV  -> saveCompany f
        DeptV     -> saveDepartment f
        EmployeeV -> saveEmployee f
            
-- response by displaying company/department/employee based on view, focus and company and possibe errors 
displayPart :: View -> Focus -> Company -> [(ENames,String)] -> ServerPart Response
displayPart v f c errs = do 
      td <- newTemplateDirectory' tDir (eNamesBinder errs $ binder f c $ emptyTemplateState tDir)
      render td (B.pack tname)
          where
            binder = case v of
              CompanyV  -> companyBinder
              DeptV     -> departmentBinder
              EmployeeV -> employeeBinder
                where
            tname = case v of
              CompanyV  -> "company"
              DeptV     -> "department"
              EmployeeV -> "employee"