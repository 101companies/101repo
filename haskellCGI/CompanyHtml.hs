module CompanyHtml where

import Text.XHtml
import Company
import API
import Action
import Total


page :: String -> Html -> Html
page t b = header << 
        (thetitle << t +++ tag "link" noHtml ! [rel "stylesheet", thetype "text/css", href "../../style.css"]) 
        +++ body << b
 
foldHtml :: [Html] -> Html
foldHtml = foldr (+++) (stringToHtml "")

companyCgiLink ::  String -> String -> Action -> Focus -> Html
companyCgiLink c n a f = anchor ! [theclass c, href $ companyUrl f a] << thediv <<  n
    where
        companyUrl f a = concat $ "company.cgi?" : ["focus=", show f, "&", "action=", show a]

editButton = companyCgiLink "editB" "Edit" View
    
backButton f = companyCgiLink "backB" "Back" View (upperFocus f) 

saveSubmit = (submit ! [theclass "saveB"]) "action" "Save"

companyForm = form ! [action "company.cgi"]

hiddenFocus :: Focus -> Html
hiddenFocus f = hidden "focus" $ show f 

hiddenAction :: Action -> Html
hiddenAction a = hidden "action" $ show a
  
totalCutDiv :: Focus -> Company -> Html
totalCutDiv f c = thediv ! [theclass "totalCut"] $ totalText
    where
        totalText = ("Total = " ++ show (total f c)++ " €") +++ companyCgiLink "cutLink" "Cut" Cut f   

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

companyHtml :: Focus -> Company -> Html
companyHtml f c = thediv ! [theclass "all"] $ 
    companyForm  ((thediv ! [theclass "nav"] $ saveSubmit)
    +++ hiddenFocus f 
    +++ br
    +++ h1 << ("Company \"" ++ getCName c ++ "\"")
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Name: ") +++ thediv << (textfield ! [value (getCName co)] $ "name")))
    +++ br
    +++ h2 << "Departments: " 
    +++ itemize co deptsFocusList readDepartment getDName f
    +++ thediv ! [theclass "space"] << noHtml
    +++ totalCutDiv f c
    where 
        co = readCompany f c
        
deptHtml :: Focus -> Company -> Html
deptHtml f c = thediv ! [theclass "all"] $ 
    companyForm ((thediv ! [theclass "nav"] $ saveSubmit +++ backButton f)
    +++ hiddenFocus f  
    +++ br
    +++ h1 << ("Department \"" ++ getDName d ++ "\"")
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Name: ") +++ thediv << (textfield ! [value (getDName d)] $ "name")))
    +++ br
    +++ (thediv ! [theclass "manager"] << (h2 << "Manager:" 
                                                +++ p ! [theclass "eName"] << (getEName $ getManager d) 
                                                +++ editButton (managerFocus f c)))  
    +++ br  
    +++ h2 << "Sub departments:"
    +++ itemize c dusFocusList readDepartment getDName f
    +++ h2 << "Employees:"
    +++ itemize c eusFocusList readEmployee getEName f
    +++ thediv ! [theclass "space"] << noHtml
    +++ totalCutDiv f c
    where 
        d = readDepartment f c     
        
employeeHtml :: Focus -> Company -> Html   
employeeHtml f co = thediv ! [theclass "all"] $ companyForm $
    (thediv ! [theclass "nav"] $ saveSubmit +++ backButton f)
    +++ hiddenFocus f      
    +++ br
    +++ h1 << ("Employee \"" ++ getEName e ++ "\"")
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Name: ") +++ thediv << (textfield ! [value (getEName e)] $ "name"))
    +++ br
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Address: ") +++ thediv << (textfield ! [value (getAddress e)] $ "address"))
    +++ br
    +++ thediv ! [theclass "editable"] << (h2 << (stringToHtml "Salary: ") 
                    +++ thediv << (textfield ! [value (show (getSalary e))] $ "salary")
                    +++ companyCgiLink "cutLinkE" "Cut" Cut f)
    where
        e = case f of
            (EmployeeFocus _ _) -> readEmployee f co
            (ManagerFocus _) -> readManager f co
