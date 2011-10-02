module Response where

import Network.CGI
import Text.XHtml
import Control.Monad (liftM)
import Data.Maybe (fromMaybe)      

import Company
import Focus
import Total
import Cut
import CompanyHtml
import Types
import Save
 
-- perform action based on focus and action parameter 
cgiMain :: CGI CGIResult
cgiMain =  do
            f <- getInput "focus"
            let focusP = maybe CompanyFocus read f
            a <- getInput "action"
            let actionP = maybe View read a
            chtml <- (doAction actionP) focusP 
            output . renderHtml . page "101companies WebApp" $ chtml
              where
                doAction ap = case ap of
                  View  -> doView
                  Cut   -> doCut
                  Save  -> doSave 
        
-- respond to view request by just returning html      
doView :: Focus -> CGI Html
doView f = do 
    liftM (html f) tryReadCCookie
    
-- performing cutting and diplay
doCut :: Focus -> CGI Html  
doCut f = do
    c <- tryReadCCookie
    let cutC = readCutWrite f c   
    writeCCookie cutC
    return $ html f cutC
 
-- save and display new company
doSave :: Focus -> CGI Html        
doSave f = do
    newCompany <- save f
    return $ html f newCompany
      where
        save = case f of
         CompanyFocus        -> cSave
         (DeptFocus _)       -> dSave
         (EmployeeFocus _ _) -> eSave
         (ManagerFocus _)    -> eSave              