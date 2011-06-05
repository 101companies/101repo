module Main where

import Company
import Total
import Cut
import SampleCompany

import Graphics.UI.WX
import Monad 
import API                                       
         

buttonsDList :: Frame () -> Panel () -> [Focus] -> Company -> IO [Layout]
buttonsDList f p fs c = buttonsXList fs c readDepartment False (showDept f) p 
    
buttonsEList :: Frame () -> Panel () -> [Focus] -> Company -> IO [Layout]
buttonsEList f p fs c = buttonsXList fs c readEmployee True (showEmployee f p) p

buttonsXList :: Nameable a => [Focus] -> Company -> (Focus -> Company -> a) -> Bool -> (Focus -> Company -> IO ()) -> Panel () -> IO [Layout]
buttonsXList fs c r b s p = do
    layouts <- mapM buttonize fs
    return $ if (null layouts) then [space 0 0] else layouts
        where
            buttonize focus = do
            let x = r focus c
            button <- button p [text := getName x, on command := do {set p [visible := b]; s focus c}]
            return $ widget button            

-- show employee view
showEmployee :: Frame () -> Panel () -> Focus -> Company -> IO ()
showEmployee f p focus c = do
    set p [enabled := False]
    let e = getEmployee focus c
    let ns = getRoute focus
    let rf = replaceFunc focus 
    f' <- frame [visible := True, textBgcolor := colorRGB 212 212 232 , text := "Employee \"" ++ getEName e ++ "\""]
    a <- get f' (on closing); -- actual closing of the frame
    set f' [on closing := do {set p [enabled := True]; a;}]             
    p' <- panel f' []
    nameBox <- entry p' [text := getEName e]
    addressBox <- entry p' [text := getAddress e]
    salaryBox <- entry p' [text := show $ getSalary e]
    cancelButton <- button p' [text := "Close", on command := close f']
    saveButton <- button p' [text := "Save", on command := do {
            newName <- get nameBox text;
            newAddress <- get addressBox text;
            newSalary <- get salaryBox text;
            close f';
            set p [visible := False];
			showDept f (DeptFocus ns) (rf focus c (Employee newName newAddress (read newSalary)))}]
    set f' [layout := container p' $ alignCentre $
                     margin 20 $   
                     column 10 [
                        alignCentre $ row 94 [label "Name:", widget nameBox],
                        alignCentre $ row 81 [label "Address:", widget addressBox],
                        alignCentre $ row 91 [label "Salary:", widget salaryBox],
                        space 0 30,
                        alignCentre $ row 10 [widget saveButton, widget cancelButton]
                     ]]
    where
        getEmployee focus@(EmployeeFocus _ _) = readEmployee focus
        getEmployee focus@(ManagerFocus _) = readManager focus
        getRoute (EmployeeFocus ns _) = ns
        getRoute (ManagerFocus ns) = ns
        replaceFunc (EmployeeFocus _ _) = writeEmployee
        replaceFunc (ManagerFocus _) = writeManager
         
                       

showDorC :: Frame () -> Focus -> Company -> IO ()
showDorC f CompanyFocus = showCompany f CompanyFocus
showDorC f focus@(DeptFocus _) = showDept f focus

-- show department view
showDept :: Frame () -> Focus -> Company -> IO ()
showDept f focus@(DeptFocus ns) c = do
    let d = readDepartment focus c
    set f [text := "Department \"" ++ getDName d ++ "\""]
    p <- panel f []
    nameBox <- entry p [text := getDName d]
    backButton <- button p [text := "Back", on command := do {set p [visible := False]; showDorC f (upperFocus focus) c;}]                                                                
    saveButton <- button p [text := "Save", on command := do {set p [visible := False]; newName <- get nameBox text; showDept f focus $ writeDepartment focus c $ setDName d newName}]
    managerButton <- button p [text := getEName $ getManager $ d]
    set managerButton [on command := showEmployee f p (ManagerFocus ns) c] 
    deptWidgets <- buttonsDList f p (dusFocusList focus c) c
    employeeWidgets <- buttonsEList f p (eusFocusList focus c) c
    cutButton <- button p [text := "Cut", on command := do {set p [visible := False]; showDept f focus $ writeDepartment focus c $ cutDept d}]
    set f [layout := container p $ alignCentre $
                     margin 20 $ 
                     minsize (sz 250 5) $  
                     column 20 [
                        alignCentre $ row 90 [label "Name:", widget nameBox], 
                        alignCentre $ row 92 [label "Manager: ", widget managerButton],
                        alignCentre $ minsize (sz 230 5) $ boxed "Employees" $ margin 10 $ alignCentre $ column 5 employeeWidgets,
                        alignCentre $ minsize (sz 230 5) $ boxed "Subdepartments" $ margin 10 $ alignCentre $ column 5 deptWidgets, 
                        alignCentre $ row 18 [label $ "Total salary = " ++ (Prelude.show $ totalDept d), widget cutButton],
                        space 0 30,
                        alignCentre $ row 10 [widget saveButton, widget backButton]   
                     ]]
                                             
-- show root view
showCompany :: Frame () -> Focus -> Company ->  IO()
showCompany f focus c = do
    let c' = readCompany focus c
    set f [text := "Company \"" ++ getCName c' ++ "\""]
    p <- panel f []
    nameBox <- entry p [text := getCName c']
    deptWidgets <- buttonsDList f p (deptsFocusList focus c) c
    cutButton <- button p [text := "Cut", on command := do {set p [visible := False]; showCompany f focus $ writeCompany focus c $ cutCompany c;}]
    set f [layout := container p $ alignCentre $
                     margin 20 $
                     minsize (sz 250 5) $   
                     column 20 [                                                                        
                        alignCentre $ row 90 [label "Name:", widget nameBox], 
                        alignCentre $ minsize (sz 230 5) $ boxed "Departments" $ margin 10 $ alignCentre $ column 5 deptWidgets, 
                        alignCentre $ row 18 [label $ "Total salary = " ++ (Prelude.show $ totalCompany c), widget cutButton]
                    ]]
       
gui :: IO ()
gui = do
    f <- frame [textBgcolor := colorRGB 212 212 232]
    showCompany f CompanyFocus company 
    
main :: IO ()
main = start $ gui