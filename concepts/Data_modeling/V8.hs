{-

V8: Adopting a flexible department structure.
We simply assume that a department consists of "units".
There are three different kinds of units:
managers, (other) employees, and subdepartments.
We introduce an extra algebraic data type for such units.
Should we use the Either type constructor instead?

-}

data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
data Employee = Employee {
    getEmployeeName :: String,
    getSalary :: Salary
}
data Department = Department {
    getDepartmentName :: Name,
    getDepartmentUnits :: [DepartmentUnit]
}
data DepartmentUnit 
  = ManagerUnit Employee
  | EngineerUnit Employee
  | SubDepartmentUnit Department
type Name = String
type Salary = Float

-- The same employees as before
e1 = Employee { getEmployeeName = "Max", getSalary = 42 }
e2 = Employee "Sean" 66
e3 = Employee "Nina" 77

-- Some departments with different kinds of units
d1 = Department "Haskell" [ManagerUnit e1]
d2 = Department "C++" [EngineerUnit e2, SubDepartmentUnit d21]
d21 = Department "C++ Vx" [EngineerUnit e3]

sampleCompany1, sampleCompany2 :: Company
sampleCompany1 = FlatCompany [e1, e2, e3]
sampleCompany2 = HiearchicalCompany [d1, d2]

total :: Company -> Salary
total (FlatCompany es) = totalEs es
total (HiearchicalCompany ds) = totalDs ds

totalEs :: [Employee] -> Salary
totalEs = sum . map getSalary

totalDs :: [Department] -> Salary
totalDs = sum . map totalD

totalD :: Department -> Salary
totalD (Department _ us) = totalUs us
  where
    totalUs :: [DepartmentUnit] -> Salary
    totalUs = sum . map totalU

totalU :: DepartmentUnit -> Salary
totalU (ManagerUnit e) = getSalary e
totalU (EngineerUnit e) = getSalary e
totalU (SubDepartmentUnit d) = totalD d
