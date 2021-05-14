{-

V9: Making a type distinction for salaries.
That is, we wrap salaries in an extra "Salary" constructor.
In this manner, we cannot confuse other types of floats with salaries.
We use a "newtype" instead of "data".
A newtype is an algebraic data type with just one constructor with a single component.
When performing addition, we return to float.
For clarity, the wrap the final total with "Salary" again.
This is a bit of a cumbersome approach. 
Perhaps, we should just make it so that salaries can be added right away?

-}

data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
data Employee = Employee {
    getEmployeeName :: String,
    getSalary :: Salary
}
data Department = Department {
    getDepartmentName :: String,
    getDepartmentUnits :: [DepartmentUnit]
}
data DepartmentUnit 
  = ManagerUnit Employee
  | EngineerUnit Employee
  | SubDepartmentUnit Department
type Name = String
-- We also need to "derive" Show for Salary.
-- Otherwise, we cannot print results.
newtype Salary = Salary Float deriving (Show)

-- The same employees as before but with the extra "Salary" constructor
e1 = Employee { getEmployeeName = "Max", getSalary = Salary 42 }
e2 = Employee "Sean" (Salary 66)
e3 = Employee "Nina" (Salary 77)

-- The same departments as before
d1 = Department "Haskell" [ManagerUnit e1]
d2 = Department "C++" [EngineerUnit e2, SubDepartmentUnit d21]
d21 = Department "C++ Vx" [EngineerUnit e3]

-- Sample companies as in previous versions
sampleCompany1, sampleCompany2 :: Company
sampleCompany1 = FlatCompany [e1, e2, e3]
sampleCompany2 = HiearchicalCompany [d1, d2]

total :: Company -> Salary
total (FlatCompany es) = Salary (totalEs es)
total (HiearchicalCompany ds) = Salary (totalDs ds)

salary2float :: Salary -> Float
salary2float (Salary s) = s

totalEs :: [Employee] -> Float
totalEs = sum . map totalE

totalE :: Employee -> Float
totalE e = salary2float (getSalary e)

totalDs :: [Department] -> Float
totalDs = sum . map totalD

totalD :: Department -> Float
totalD (Department _ us) = totalUs us

totalUs :: [DepartmentUnit] -> Float
totalUs = sum . map totalU

totalU :: DepartmentUnit -> Float
totalU (ManagerUnit e) = totalE e
totalU (EngineerUnit e) = totalE e
totalU (SubDepartmentUnit d) = totalD d
