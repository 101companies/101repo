module API where

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

-- "sub" focuses

upperFocus :: Focus -> Focus
upperFocus (DeptFocus [_]) = CompanyFocus
upperFocus (DeptFocus ns) = DeptFocus $ init ns
upperFocus (EmployeeFocus ns _) = DeptFocus ns 
upperFocus (ManagerFocus ns) = DeptFocus ns

managerFocus :: Focus -> Company -> Focus
managerFocus focus@(DeptFocus ns) _ = ManagerFocus ns

eusFocusList :: Focus -> Company -> [Focus]
eusFocusList focus@(DeptFocus ns) c = map (EmployeeFocus ns)  [0..(length $ getEus $ readDepartment focus c) - 1]

dusFocusList :: Focus -> Company -> [Focus]
dusFocusList focus@(DeptFocus ns) c = map (\n -> DeptFocus (ns ++ [n]))  [0..(length $ getDus $ readDepartment focus c) - 1]

deptsFocusList :: Focus -> Company -> [Focus]
deptsFocusList focus@CompanyFocus c = map (\n -> DeptFocus [n]) [0..(length $ getDepts $ readCompany focus c) - 1] 
 

-- read/write per Focus data constructor

class Readable a where
    readA :: Focus -> Company -> a

instance Readable Company where
    readA = readCompany

instance Readable Department where
    readA = readDepartment
    
instance Readable Employee where
    readA f@(EmployeeFocus _ _) = readEmployee f
    readA f@(ManagerFocus _) = readManager f
    
class Writeable a where
    writeA :: Focus -> Company -> a -> Company
    
instance Writeable Company where
    writeA = writeCompany
    
instance Writeable Department where
    writeA = writeDepartment
    
instance Writeable Employee where
    writeA f@(EmployeeFocus _ _) = writeEmployee f
    writeA f@(ManagerFocus _) = writeManager f

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

getEName (Employee name _ _) = name
setEName (Employee _ address salary) name = Employee name address salary

getAddress (Employee _ address _) = address
setAddress (Employee name _ salary) address = Employee name address salary

getSalary (Employee _ _ salary) = salary
setSalary (Employee name address _) salary = Employee name address salary
                                        
replaceEmployee :: [Employee] -> Name -> Employee -> [Employee]
replaceEmployee [] _ _ = []
replaceEmployee (e@(Employee name address salary):es) sName newE | name == sName = newE:es
                                                                 | otherwise     = e:(replaceEmployee es sName newE)                                         
-- read, apply a set function and write back
readSetWrite :: (Readable a, Writeable a) => (a -> a) -> Focus -> Company -> Company
readSetWrite s f c = writeA f c $ s (readA f c)  


-- Departments and employees have names
class Nameable a where
    getName :: a -> String
    
instance Nameable Department where
    getName = getDName
    
instance Nameable Employee where
    getName = getEName 