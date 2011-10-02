{-# LANGUAGE OverloadedStrings #-}

module Save where

import Control.Monad (msum)
import Happstack.Server (CookieLife(Session), addCookie, mkCookie, readCookieValue)
import Happstack.Server.Internal.Monads
import Control.Monad
import Happstack.Server.RqData (look, lookRead)                               
 
import Company                               
import Focus
import Cut
import Types
import Validators

tDir = "templates"

readCCookie = readCookieValue "company"

-- save s.th by reading the parameters, validating them 
-- and re-setting the cookie

saveCompany :: Focus -> ServerPartT IO (Either [(ENames,String)] Company)
saveCompany f = do
  c <- readCCookie
  let co@(Company n ds) = readCompany f c
  name <- look "Name"
  let newc' = Company name ds
  let cv = validateCompany c f newc'
  case cv of 
    (Just errs)
        -> return $ Left errs
    Nothing
        -> do
             let newc = writeCompany f c newc'
             addCookie Session (mkCookie "company" (show newc))
             return $ Right newc 

saveDepartment :: Focus -> ServerPartT IO (Either [(ENames,String)] Company)
saveDepartment f = do
  c <- readCCookie
  let d@(Department n m dus eus) = readDepartment f c
  name <- look "Name"
  let newd = Department name m dus eus
  let dv = validateDept c f newd
  case dv of
    (Just errs) 
        -> return $ Left errs
    Nothing
        -> do
            let newc = writeDepartment f c newd
            addCookie Session (mkCookie "company" (show newc))
            return $ Right newc
            
saveEmployee :: Focus -> ServerPartT IO (Either [(ENames,String)] Company)
saveEmployee f = do
  c <- readCCookie
  let e@(Employee n a s) = readEM f c
  name <- look "Name"
  address <- look "Address"
  salary <- lookRead "Salary"
  let newe = Employee name address salary
  let ev = validateEmployee c f newe
  case ev of
    (Just errs)
        -> return $ Left errs
    Nothing
        -> do
            let newc = writeEM f c newe
            addCookie Session (mkCookie "company" (show newc))
            return $ Right newc
              

          