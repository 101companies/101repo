module CompanyHtml where

import Text.XHtml hiding (address)
import Company
import Focus
import Types
import Total

-- page has a stylesheet
page :: String -> Html -> Html
page t b = header << 
        (thetitle << t +++ tag "link" noHtml ! [rel "stylesheet", thetype "text/css", href "../../style.css"]) 
        +++ body << b

-- fold html by means of (+++) 
foldHtml :: [Html] -> Html
foldHtml = foldr (+++) (stringToHtml "")

-- company cgi link for form action attributes
companyCgiLink ::  String -> String -> Action -> Focus -> Html
companyCgiLink c n a f = anchor ! [theclass c, href $ companyUrl f a] << thediv <<  n
    where
        companyUrl f a = concat $ "company.cgi?" : ["focus=", show f, "&", "action=", show a]


-- buttons
editButton = companyCgiLink "editB" "Edit" View
    
backButton f = companyCgiLink "backB" "Back" View (upperFocus f) 

-- submit for forms
saveSubmit = (submit ! [theclass "saveB"]) "action" "Save"

-- form
companyForm = form ! [action "company.cgi"]


-- hidden actions for html forms
hiddenFocus :: Focus -> Html
hiddenFocus f = hidden "focus" $ show f 

hiddenAction :: Action -> Html
hiddenAction a = hidden "action" $ show a
 
-- total and cut container  
totalCutDiv :: Focus -> Company -> Html
totalCutDiv f c = thediv ! [theclass "totalCut"] $ totalText
    where
        totalText = ("Total = " ++ show (total f c)++ " €") +++ companyCgiLink "cutLink" "Cut" Cut f   

-- create option list for a list of employees or departents
itemize :: Company -> (Focus -> Company -> [Focus]) -> (Focus -> Company -> a) -> (a -> String) -> Focus -> Html
itemize c list readX nameX f = 
    form ! [action $ "company.cgi", theclass "sel"] << 
        (select ! [size $ show $ length fs + 2, name "focus"] << foldHtml (map item (list f c))
        +++ br
        +++ hiddenAction View
        +++ input ! [thetype "submit", value "Edit"])
    where
        fs = list f c
        item f'  = option ! [value $ show f'] $ stringToHtml $ nameX $ readX f' c 

-- compose html based on focus
html :: Focus -> Company -> Html
html f = case f of 
  CompanyFocus        -> companyHtml f
  (DeptFocus _)       -> deptHtml f
  (EmployeeFocus _ _) -> employeeHtml f
  (ManagerFocus _)    -> employeeHtml f   

-- html for a company
companyHtml :: Focus -> Company -> Html
companyHtml f c = thediv ! [theclass "all"] $ 
    companyForm  ((thediv ! [theclass "nav"] $ saveSubmit)
    +++ hiddenFocus f 
    +++ br
    +++ h1 << ("Company \"" ++ cname c ++ "\"")
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Name: ") +++ thediv << (textfield ! [value (cname co)] $ "name")))
    +++ br
    +++ h2 << "Departments: " 
    +++ itemize co deptsFocusList readDepartment dname f
    +++ thediv ! [theclass "space"] << noHtml
    +++ totalCutDiv f c
    where 
        co = readCompany f c

-- html for a department        
deptHtml :: Focus -> Company -> Html
deptHtml f c = thediv ! [theclass "all"] $ 
    companyForm ((thediv ! [theclass "nav"] $ saveSubmit +++ backButton f)
    +++ hiddenFocus f  
    +++ br
    +++ h1 << ("Department \"" ++ dname d ++ "\"")
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Name: ") +++ thediv << (textfield ! [value (dname d)] $ "name")))
    +++ br
    +++ (thediv ! [theclass "manager"] << (h2 << "Manager:" 
                                                +++ p ! [theclass "eName"] << (ename $ manager d) 
                                                +++ editButton (managerFocus f c)))  
    +++ br  
    +++ h2 << "Sub departments:"
    +++ itemize c dusFocusList readDepartment dname f
    +++ h2 << "Employees:"
    +++ itemize c eusFocusList readEmployee ename f
    +++ thediv ! [theclass "space"] << noHtml
    +++ totalCutDiv f c
    where 
        d = readDepartment f c     

-- html for an employee        
employeeHtml :: Focus -> Company -> Html   
employeeHtml f co = thediv ! [theclass "all"] $ companyForm $
    (thediv ! [theclass "nav"] $ saveSubmit +++ backButton f)
    +++ hiddenFocus f      
    +++ br
    +++ h1 << ("Employee \"" ++ ename e ++ "\"")
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Name: ") +++ thediv << (textfield ! [value (ename e)] $ "name"))
    +++ br
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Address: ") +++ thediv << (textfield ! [value (address e)] $ "address"))
    +++ br
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Salary: ") 
                    +++ thediv << (textfield ! [value (show (salary e))] $ "salary")
                    +++ companyCgiLink "cutLinkE" "Cut" Cut f)
    where
        e = case f of
            (EmployeeFocus _ _) -> readEmployee f co
            (ManagerFocus _) -> readManager f co
