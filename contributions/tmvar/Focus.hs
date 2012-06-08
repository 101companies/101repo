module Focus where
import Company
import SampleCompany

data Focus = 
     CompanyFocus
   | DeptFocus [Int]
   | ManagerFocus [Int]
   | EmployeeFocus [Int] Int
    deriving (Show, Read)
   
replaceAt 0 newX (_:xs) = newX:xs
replaceAt n newX (x:xs) = x:replaceAt (n-1) newX xs

-- sub and upper foci

upperFocus :: Focus -> Focus
upperFocus (DeptFocus [_]) = CompanyFocus
upperFocus (DeptFocus ns) = DeptFocus $ init ns
upperFocus (EmployeeFocus ns _) = DeptFocus ns 
upperFocus (ManagerFocus ns) = DeptFocus ns

managerFocus :: Focus -> Company -> Focus
managerFocus focus@(DeptFocus ns) _ = ManagerFocus ns

eusFocusList :: Focus -> Company -> [Focus]
eusFocusList focus@(DeptFocus ns) c = map (EmployeeFocus ns)  [0..(length $ eus $ readDepartment focus c) - 1]

dusFocusList :: Focus -> Company -> [Focus]
dusFocusList focus@(DeptFocus ns) c = map (\n -> DeptFocus (ns ++ [n]))  [0..(length $ dus $ readDepartment focus c) - 1]

deptsFocusList :: Focus -> Company -> [Focus]
deptsFocusList focus@CompanyFocus c = map (\n -> DeptFocus [n]) [0..(length $ depts $ readCompany focus c) - 1] 
 
-- "first" employee focus in a company
firstEmployeeFocus :: Company -> Maybe Focus
firstEmployeeFocus (Company _ (d:_)) = Just $ ManagerFocus [0]
firstEmployeeFocus (Company _ []) = Nothing

upperNextDept :: Company -> Focus -> Maybe Focus
upperNextDept c focus@(DeptFocus ns) =
    case upperFocus focus of 
        CompanyFocus -> if ((last ns) + 1 >= (length $ depts c)) then Nothing else Just (DeptFocus [(last ns) + 1])
        focus'@(DeptFocus ns') -> if ((last ns) + 1 >= (length $ dus $ readDepartment focus' c)) then (upperNextDept company focus') else Just (DeptFocus (init ns ++ [last ns + 1]))

-- "next" employee focus in a company
nextEmployeeFocus :: Company -> Focus -> Maybe Focus
nextEmployeeFocus c (ManagerFocus ns) = 
    if (not (null (eus dept))) then (Just $ EmployeeFocus ns 0) else
        if (not (null (dus dept))) then Just $ ManagerFocus (ns ++ [0]) else 
            case upperNextDept c (DeptFocus ns) of
                                        Just (DeptFocus ns') -> Just (ManagerFocus ns')
                                        Nothing              -> Nothing
    where
        dept = readDepartment (DeptFocus ns) c

nextEmployeeFocus c (EmployeeFocus ns n) = 
    if (n + 1 < (length (eus dept))) then (Just $ EmployeeFocus ns (n + 1)) else
        if (not (null (dus dept))) then Just $ ManagerFocus (ns ++ [0]) else 
            case upperNextDept c (DeptFocus ns) of
                                        Just (DeptFocus ns') -> Just (ManagerFocus ns')
                                        Nothing              -> Nothing
    where
        dept = readDepartment (DeptFocus ns) c

allEmployeesFocus :: Company -> [Focus]
allEmployeesFocus c = case (firstEmployeeFocus c) of
    (Just focus) -> reverse $ nextEmployeesFocus c [focus]
    Nothing      -> []

nextEmployeesFocus c (f:fs) = case (nextEmployeeFocus c f) of
    (Just focus) -> nextEmployeesFocus c (focus:f:fs)
    Nothing -> (f:fs)


-- read/write per focus data constructor
readCompany :: Focus -> Company -> Company
readCompany CompanyFocus c = c

writeCompany :: Focus -> Company -> Company -> Company
writeCompany CompanyFocus _ c = c
   
readDepartment :: Focus -> Company -> Department
readDepartment (DeptFocus ns) (Company _ depts) = readStep ns depts                 
    where
        readStep [n] depts = depts !! n
        readStep (n:ns) depts = readStep ns $ dus $ depts !! n
        
writeDepartment :: Focus -> Company -> Department -> Company
writeDepartment (DeptFocus ns) (Company name depts) dept = Company name $ writeStep ns depts dept
    where
        writeStep [n] depts dept = replaceAt n dept depts
        writeStep (n:ns) depts dept = replaceAt n (replaceDus (depts !! n) (writeStep ns (dus (depts !! n)) dept)) depts            
        replaceDus (Department name m _ eus) newDus = Department name m newDus eus 
        
readManager :: Focus -> Company -> Employee
readManager (ManagerFocus ns) c = manager $ readDepartment (DeptFocus ns) c        
 
writeManager :: Focus -> Company -> Employee -> Company 
writeManager (ManagerFocus ns) c manager = writeDepartment (DeptFocus ns) c (replaceManager (readDepartment (DeptFocus ns) c))
    where
        replaceManager (Department name _ dus eus) = Department name manager dus eus 
        
readEmployee :: Focus -> Company -> Employee
readEmployee (EmployeeFocus ns m) c = (eus (readDepartment (DeptFocus ns) c)) !! m

writeEmployee :: Focus -> Company -> Employee -> Company
writeEmployee (EmployeeFocus ns m) c employee = writeDepartment (DeptFocus ns) c (replaceEmployee (readDepartment (DeptFocus ns) c))
    where
        replaceEmployee (Department name manager dus eus) = Department name manager dus (replaceAt m employee eus)      

-- employee or manager
readEM :: Focus -> Company -> Employee
readEM f@(ManagerFocus _) = readManager f
readEM f@(EmployeeFocus _ _) = readEmployee f

writeEM :: Focus -> Company -> Employee -> Company
writeEM f@(ManagerFocus _) = writeManager f
writeEM f@(EmployeeFocus _ _) = writeEmployee f   