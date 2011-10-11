module Views(viewCompany, viewDept, viewEmployee) where

import Company
import Total
import Cut
import SampleCompany

import Graphics.UI.WX hiding (when)
import Control.Monad 
import Focus   

-- helper         
textBlue = colorRGB 18 19 51

if_ b x = if b then x else return ()

view:: Frame () -> Focus -> Company -> IO ()
view f focus = view' f focus
  where 
    view' = case focus of
              CompanyFocus        -> viewCompany
              (DeptFocus _)       -> viewDept
              (EmployeeFocus _ _) -> viewEmployee
              (ManagerFocus _)    -> viewEmployee

-- create listbox from given list of nameables
listAll :: Panel () -> Company -> (Focus -> Company -> IO ()) -> [Focus] -> [a] -> (a -> String) -> IO (SingleListBox ())
listAll p c shw fs xs getName = do
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
backButton :: Panel () -> Frame () -> Focus -> Company -> IO (Button ())
backButton p f focus c = 
  button p [ text := "Back"
           , size := Size 50 22
           , on command := do {
                objectDelete p; 
                view f (upperFocus focus) c;}]  
                                    
-- cutButton
cutButton :: Panel () -> Frame () -> Focus -> Company -> IO (Button ())
cutButton p f focus c = 
  button p [ text := "Cut"      
           , size := Size 50 22                                                                
           , on command := do {
                objectDelete p; 
                view f focus $ readCutWrite focus c;}]                                              

-- view company (root)
viewCompany :: Frame () -> Focus -> Company ->  IO()
viewCompany f focus c = do   
    -- read company
    let c' = readCompany focus c
    -- setting up frames and panels
    set f [text := "Company \"" ++ cname c' ++ "\""]
    p <- panel f [textColor := textBlue]
    -- box for company name
    nameBox <- entry p [text := cname c']
    -- menu
    sButton <- button p [ text := "Save"
                        , size := Size 50 22
                        , on command := do {
                              newName <- get nameBox text;
                              objectDelete p; 
                              viewCompany f focus $ writeCompany focus c' $ Company newName (depts c')}]
    --listbox for departements
    deptsListBox <- listAll p c' (viewDept f) (deptsFocusList focus c') (depts c') dname
    -- cut button
    cButton <- cutButton p f focus c'
    -- compose layout                                
    set f [layout := container p $ alignCentre $
                     margin 20 $
                     minsize (sz 250 5) $   
                     column 15 [
                        alignLeft $ row 10 [widget sButton],
                        hrule 250,                                                                      
                        alignCentre $ row 90 [label "Name:", widget nameBox], 
                        alignCentre $ minsize (sz 230 5) $ boxed "Departments:" $ margin 10 $ alignCentre $ column 5 [widget deptsListBox],
                        alignCentre $ row 18 [label $ "Total salary = " ++ (show $ totalCompany c), widget cButton]
                    ]]
         
                                
                                   
-- view department
viewDept :: Frame () -> Focus -> Company -> IO ()
viewDept f focus@(DeptFocus ns) c = do
    -- reading the department
    let d = readDepartment focus c
    -- setting up frames and panels
    set f [text := "Department \"" ++ dname d ++ "\""]
    p <- panel f [textColor := textBlue]
    -- box for department name
    nameBox <- entry p [text := dname d]
    -- menu buttons
    bButton <- backButton p f focus c                                                              
    sButton <- button p [ text := "Save"
                        , size := Size 50 22
                        , on command := do {
                              newName <- get nameBox text;
                              objectDelete p;  
                              viewDept f focus $ writeDepartment focus c $ Department newName (manager d) (dus d) (eus d)}]
    -- manager with edit button
    mButton <- button p [ text := "Edit"
                        , size := Size 50 22]
    managerBox <- entry p [ text := ename $ manager d
                          , color := textBlue
                          , enabled := False   
                          ]                  
    set mButton [on command := do {
                      objectDelete p; 
                      viewEmployee f (ManagerFocus ns) c}]
    -- listbox for sub departments with edit button
    p' <- panel f [textColor := textBlue]
    dusListBox <- listAll p c (viewDept f) (dusFocusList focus c) (dus d) dname 
    -- listbox for employees with edit button 
    eusListBox <- listAll p c (viewEmployee f) (eusFocusList focus c) (eus d) ename
    -- cutButton
    cButton <- cutButton p f focus c
    -- compose layout
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
                        alignCentre $ row 18 [label $ "Total salary = " ++ (show $ totalDept d), widget cButton]  
                     ]]
                                             

                    
 
-- view employee view based on
viewEmployee :: Frame () -> Focus -> Company -> IO ()
viewEmployee f focus c = do
    -- reading employee
    let e = readEM focus c
    -- setting up frames and panels
    set f [ text := "Employee \"" ++ ename e ++ "\""]
    p <- panel f [textColor := textBlue]
    -- boxes for name, address and salary
    nameBox <- entry p [text := ename e]                                    
    addressBox <- entry p [text := address e]
    salaryBox <- entry p [text := show $ salary e]
    -- cut button
    cButton <- cutButton p f focus c
    -- back button                                
    bButton <- backButton p f focus c           
    -- save button                                                             
    sButton <- button  p [ text := "Save"
                         , size := Size 50 22 
                         , on command := do { 
                             newName <- get nameBox text;
                             newAddress <- get addressBox text;
                             newSalary <- get salaryBox text;
                             objectDelete p;
                             newc <- return $ (writeEM focus c (Employee newName newAddress (read newSalary)));
			                       viewEmployee f focus newc; }]
    -- compose layout                                 
    set f [layout := container p $ alignCentre $
                     margin 20 $   
                     column 10 [
                        alignLeft $ row 10 [widget sButton, widget bButton],
                        hrule 250,
                        alignCentre $ row 94 [label "Name:", widget nameBox],
                        alignCentre $ row 81 [label "Address:", widget addressBox],
                        alignCentre $ row 91 [label "Salary:", widget salaryBox],
                        alignRight $ margin 10 $ widget cButton
                     ]]               