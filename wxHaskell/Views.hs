module Views(showCompany, showDept, showEmployee) where

import Company
import Total
import Cut
import SampleCompany

import Graphics.UI.WX hiding (when)
import Monad 
import API   

-- helper         
textBlue = colorRGB 18 19 51

if_ b x = if b then x else return ()

showDorC :: Frame () -> Panel () -> Focus -> Company -> IO ()
showDorC f p CompanyFocus = showCompany f p CompanyFocus
showDorC f p focus@(DeptFocus _) = showDept f p focus

-- create listbox from given list of nameables
listAll :: Nameable a => Panel () -> Company  -> (Focus -> Company -> IO ()) -> [Focus] -> [a] -> IO (SingleListBox ())
listAll p c shw fs xs = do
  lb <- singleListBox p [ textBgcolor := colorRGB 112 128 144 
                        , textColor := white
                        , fontWeight := WeightBold
                        , fontUnderline := False ]
  set lb [on select := do {
                            i <- get lb selection;
                            if_ (i /= (-1)) $ do {
                                objectDelete p; 
                                shw (fs !! i) c}}]
  mapM_ ((itemAppend lb).getName) xs
  return lb  
-- /helper 

-- backbutton
backButton p f focus c = button p [ text := "Back"
                               , size := Size 50 22
                               , on command := do {
                                    objectDelete p;
                                    p' <- panel f [textColor := textBlue]; 
                                    showDorC f p' (upperFocus focus) c;}]  
                                    
-- cutButton
cutButton p f focus c shw = button p [ text := "Cut"      
                               , size := Size 50 22                                                                
                               , on command := do {
                                    objectDelete p; 
                                    p' <- panel f [textColor := textBlue];
                                    shw f p' focus $ readCutWrite focus c;}]                                              

-- show company (root)
showCompany :: Frame () -> Panel () -> Focus -> Company ->  IO()
showCompany f p focus c = do   
    -- read company
    let c' = readCompany focus c
    -- setting up frames and panels
    set f [text := "Company \"" ++ getCName c' ++ "\""]
    -- box for company name
    nameBox <- entry p [text := getCName c']
    -- menu
    sButton <- button p [ text := "Save"
                        , size := Size 50 22
                        , on command := do {
                              newName <- get nameBox text;
                              objectDelete p;
                              p' <- panel f [textColor := textBlue]; 
                              showCompany f p' focus $ writeCompany focus c' $ setCName c' newName}]
    --listbox for departements
    p' <- panel f [textColor := textBlue]
    deptsListBox <- listAll p c' (showDept f p') (deptsFocusList focus c') (getDepts c')
    -- cut button
    cButton <- cutButton p f focus c' showCompany
    -- total company salary
    let total = totalCompany c
    -- compose layout                                
    setCompanyLayout f p sButton nameBox deptsListBox total cButton
                           
-- layout composer for companies
setCompanyLayout f p sButton nameBox deptsListBox total cButton =
    set f [layout := container p $ alignCentre $
                     margin 20 $
                     minsize (sz 250 5) $   
                     column 15 [
                        alignLeft $ row 10 [widget sButton],
                        hrule 250,                                                                      
                        alignCentre $ row 90 [label "Name:", widget nameBox], 
                        alignCentre $ minsize (sz 230 5) $ boxed "Departments:" $ margin 10 $ alignCentre $ column 5 [widget deptsListBox],
                        alignCentre $ row 18 [label $ "Total salary = " ++ (Prelude.show total), widget cButton]
                    ]]
          
                                   
-- show department
showDept :: Frame () -> Panel () -> Focus -> Company -> IO ()
showDept f p focus@(DeptFocus ns) c = do
    -- reading the department
    let d = readDepartment focus c
    -- setting up frames and panels
    set f [text := "Department \"" ++ getDName d ++ "\""]
    -- box for department name
    nameBox <- entry p [text := getDName d]
    -- menu buttons
    bButton <- backButton p f focus c                                                              
    sButton <- button p [ text := "Save"
                        , size := Size 50 22
                        , on command := do {
                              newName <- get nameBox text;
                              objectDelete p; 
                              p' <- panel f [textColor := textBlue]; 
                              showDept f p' focus $ writeDepartment focus c $ setDName d newName}]
    -- manager with edit button
    mButton <- button p [ text := "Edit"
                        , size := Size 50 22]
    managerBox <- entry p [ text := getEName $ getManager d
                          , color := textBlue
                          , enabled := False   
                          ]                  
    set mButton [on command := do {
                      objectDelete p;
                      p' <- panel f [textColor := textBlue]; 
                      showEmployee f p' (ManagerFocus ns) c}]
    -- listbox for sub departments with edit button
    p' <- panel f [textColor := textBlue]
    dusListBox <- listAll p c (showDept f p') (dusFocusList focus c) (getDus d) 
    -- listbox for employees with edit button 
    eusListBox <- listAll p c (showEmployee f p') (eusFocusList focus c) (getEus d)
    -- cutButton
    cButton <- cutButton p f focus c showDept
    -- total department salary
    let total = totalDept d
    -- compose layout
    setDeptLayout f p sButton bButton nameBox managerBox mButton dusListBox eusListBox total cButton
    
-- layout composer for departments   
setDeptLayout f p sButton bButton nameBox managerBox mButton dusListBox eusListBox total cButton = 
     set f [layout := container p $ alignCentre $
                     margin 20 $ 
                     minsize (sz 250 5) $  
                     column 15 [
                        alignLeft $ row 10 [widget sButton, widget bButton],
                        hrule 250,                    
                        alignCentre $ row 90 [label "Name:", widget nameBox], 
                        alignCentre $ row 10 [label "Manager: ", widget managerBox, widget mButton],
                        alignCentre $ minsize (sz 230 5) $ boxed "Sub departments:" $ margin 10 $ alignCentre $ column 5 [widget dusListBox],
                        alignCentre $ minsize (sz 230 5) $ boxed "Employees;" $ margin 10 $ alignCentre $ column 5  $ [widget eusListBox],    
                        alignCentre $ row 18 [label $ "Total salary = " ++ (Prelude.show total), widget cButton]  
                     ]]
                                             
               
 
-- show employee view based on
showEmployee :: Frame () -> Panel () -> Focus -> Company -> IO ()
showEmployee f p focus c = do
    -- reading employee
    let e = readEM focus c
    set f [ text := "Employee \"" ++ getEName e ++ "\""]
    -- boxes for name, address and salary
    nameBox <- entry p [text := getEName e]                                    
    addressBox <- entry p [text := getAddress e]
    salaryBox <- entry p [text := show $ getSalary e]
    -- cut button
    cButton <- cutButton p f focus c showEmployee
    -- back button                                
    bButton <- backButton p f focus c           
    -- save button                                                             
    sButton <- button  p 
          [ text := "Save"
          , size := Size 50 22 
          , on command := do { 
              newName <- get nameBox text;
              newAddress <- get addressBox text;
              newSalary <- get salaryBox text;
              objectDelete p;
              p' <- panel f [textColor := textBlue];
              showEmployee f p' focus $ 
               writeEM focus c $ 
                Employee newName newAddress $ 
                 read newSalary; }]
    -- compose layout                                 
    setEmployeeLayout f p sButton bButton nameBox addressBox salaryBox cButton
    
    
-- layout composer for employees        
setEmployeeLayout f p sButton bButton nameBox addressBox salaryBox cButton =
    set f [layout := 
      container p $ alignCentre $
      margin 20 $   
      column 10 [
        alignLeft $ row 10 [widget sButton, widget bButton],
        hrule 250,
        alignCentre $ 
            row 94 [label "Name:", widget nameBox],
        alignCentre $ 
            row 81 [label "Address:", widget addressBox],
        alignCentre $ 
            row 91 [label "Salary:", widget salaryBox],
        alignRight $ margin 10 $ widget cButton ]]  
     
                    