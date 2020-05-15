-- V8: Adopting a flexible department structure
data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
data Employee = Employee {
    getEmployeeName :: String,
    getSalary :: Float
}
data Department = Department {
    getDepartmentName :: String,
    getDepartmentUnits :: [DepartmentUnit]
}
data DepartmentUnit 
  = ManagerUnit Employee
  | EngineerUnit Employee
  | SubDepartmentUnit Department

-- Some employees
e1 = Employee { getEmployeeName = "Max", getSalary = 42 }
e2 = Employee "Sean" 66
e3 = Employee "Nina" 77

sampleCompany1 :: Company
sampleCompany1 = FlatCompany [e1, e2, e3]

sampleCompany2 :: Company
sampleCompany2 = HiearchicalCompany [d1, d2]
  where
    d1 = Department "Haskell" [
           ManagerUnit e1
         ]
    d2 = Department "C++" [
           EngineerUnit e2,
           SubDepartmentUnit d21
         ]
    d21 = Department "C++ Vx" [
            EngineerUnit e3
          ]

total :: Company -> Float
total (FlatCompany es) = totalEs es
total (HiearchicalCompany ds) = totalDs ds

totalEs :: [Employee] -> Float
totalEs = sum . map getSalary

totalDs :: [Department] -> Float
totalDs = sum . map totalD

totalD :: Department -> Float
totalD (Department _ us) = totalUs us

totalUs :: [DepartmentUnit] -> Float
totalUs = sum . map totalU

totalU (ManagerUnit e) = getSalary e
totalU (EngineerUnit e) = getSalary e
totalU (SubDepartmentUnit d) = totalD d
