module API where

import Company
import SampleCompany

data Focus = 
     CompanyFocus
   | DeptFocus [Int]
   | ManagerFocus [Int]
   | EmployeeFocus [Int] Int
   
replaceAt 0 newX (_:xs) = newX:xs
replaceAt n newX (x:xs) = x:replaceAt (n-1) newX xs

-- "sub" focuses

upperFocus :: Focus -> Focus
upperFocus (DeptFocus [_]) = CompanyFocus
upperFocus (DeptFocus ns) = DeptFocus $ init ns
upperFocus (EmployeeFocus ns _) = DeptFocus ns 

eusFocusList :: Focus -> Company -> [Focus]
eusFocusList focus@(DeptFocus ns) c = map (EmployeeFocus ns)  [0..(length $ getEus $ readDepartment focus c) - 1]

dusFocusList :: Focus -> Company -> [Focus]
dusFocusList focus@(DeptFocus ns) c = map (\n -> DeptFocus (ns ++ [n]))  [0..(length $ getDus $ readDepartment focus c) - 1]

deptsFocusList :: Focus -> Company -> [Focus]
deptsFocusList focus@CompanyFocus c = map (\n -> DeptFocus [n]) [0..(length $ getDepts $ readCompany focus c) - 1] 
 

-- read/write per Focus data constructor

readCompany :: Focus -> Company -> Company
readCompany CompanyFocus c = c

writeCompany :: Focus -> Company -> Company -> Company
writeCompany CompanyFocus _ c = c
   
readDepartment :: Focus -> Company -> Department
readDepartment (DeptFocus ns) (Company _ depts) = readStep ns depts
    where
        readStep [n] depts = depts !! n
        readStep (n:ns) depts = readStep ns $ getDus $ depts !! n
        
writeDepartment :: Focus -> Company -> Department -> Company
writeDepartment (DeptFocus ns) (Company name depts) dept = Company name $ writeStep ns depts dept
    where
        writeStep [n] depts dept = replaceAt n dept depts
        writeStep (n:ns) depts dept = replaceAt n (replaceDus (depts !! n) (writeStep ns (getDus (depts !! n)) dept)) depts            
        replaceDus (Department name m _ eus) newDus = Department name m newDus eus 
        
readManager :: Focus -> Company -> Employee
readManager (ManagerFocus ns) c = getManager $ readDepartment (DeptFocus ns) c        
 
writeManager :: Focus -> Company -> Employee -> Company 
writeManager (ManagerFocus ns) c manager = writeDepartment (DeptFocus ns) c (replaceManager (readDepartment (DeptFocus ns) c))
    where
        replaceManager (Department name _ dus eus) = Department name manager dus eus 
        
readEmployee :: Focus -> Company -> Employee
readEmployee (EmployeeFocus ns m) c = (getEus (readDepartment (DeptFocus ns) c)) !! m

writeEmployee :: Focus -> Company -> Employee -> Company
writeEmployee (EmployeeFocus ns m) c employee = writeDepartment (DeptFocus ns) c (replaceEmployee (readDepartment (DeptFocus ns) c))
    where
        replaceEmployee (Department name manager dus eus) = Department name manager dus (replaceAt m employee eus)      

-- getter/setter
-- company

getCName (Company name _) = name
setCName (Company _ depts) name = Company name depts

getDepts (Company _ depts) = depts
setDepts (Company name _) depts = Company name depts
 
-- department

getDName (Department name _ _ _) = name
setDName (Department _ m dus eus) name = Department name m dus eus
        
getManager (Department _ m _ _ ) = m
setManager (Department name _ dus eus) manager = Department name manager dus eus
                
getDus (Department _ _ dus _) = dus
setDus (Department name manager _ eus) dus = Department name manager dus eus 

getEus :: Department -> [Employee]
getEus (Department _ _ _ eus) = eus 
    
-- employee

getEName :: Employee -> Name
getEName (Employee name _ _) = name

getAddress :: Employee -> Address
getAddress (Employee _ address _) = address

getSalary :: Employee -> Float
getSalary (Employee _ _ salary) = salary
                                        
replaceEmployee :: [Employee] -> Name -> Employee -> [Employee]
replaceEmployee [] _ _ = []
replaceEmployee (e@(Employee name address salary):es) sName newE | name == sName = newE:es
                                                                 | otherwise     = e:(replaceEmployee es sName newE)                                         

-- Departments and employees have names
class Nameable a where
    getName :: a -> String
    
instance Nameable Department where
    getName = getDName
    
instance Nameable Employee where
    getName = getEName
