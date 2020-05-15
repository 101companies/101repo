-- V9: Making a type distinction for salaries
data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
data Employee = Employee {
    getEmployeeName :: String,
    getSalary :: Salary
}
-- data Salary = Salary Float
newtype Salary = Salary Float
data Department = Department {
    getDepartmentName :: String,
    getDepartmentUnits :: [DepartmentUnit]
}
data DepartmentUnit 
  = ManagerUnit Employee
  | EngineerUnit Employee
  | SubDepartmentUnit Department

-- Some employees
e1 = Employee { getEmployeeName = "Max", getSalary = Salary 42 }
e2 = Employee "Sean" (Salary 66)
e3 = Employee "Nina" (Salary 77)

sampleCompany1 :: Company
sampleCompany1 = FlatCompany [e1, e2, e3]

sampleCompany2 :: Company
sampleCompany2 = HiearchicalCompany [d1, d2]
  where
    d1 = Department "Haskell" [
           ManagerUnit m1
         ]
    d2 = Department "C++" [
           EngineerUnit e2,
           SubDepartmentUnit d21
         ]
    d21 = Department "C++ Vx" [
            EngineerUnit e3
          ]
    m1 = e1

total :: Company -> Float
total (FlatCompany es) = totalEs es
total (HiearchicalCompany ds) = totalDs ds

getSalary' :: Employee -> Float
getSalary' (Employee _ (Salary s)) = s

totalEs :: [Employee] -> Float
totalEs = sum . map getSalary'

totalDs :: [Department] -> Float
totalDs = sum . map totalD

totalD :: Department -> Float
totalD (Department _ us) = totalUs us

totalUs :: [DepartmentUnit] -> Float
totalUs = sum . map totalU

totalU (ManagerUnit e) = getSalary' e
totalU (EngineerUnit e) = getSalary' e
totalU (SubDepartmentUnit d) = totalD d
