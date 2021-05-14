{-

V7: Use record types for clarifying the roles of structural components.
We use a record type to combine name and salary into an employee.
We use another record type for departments.
Haskell's record types are algebraic data types with names for the constructor components.

-}

data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
data Employee = Employee {
    getEmployeeName :: Name,
    getSalary :: Salary
}
data Department = Department {
    getDepartmentName :: String,
    getManager :: Maybe Employee,
    getEmployees :: [Employee],
    getSubDepartments :: [Department]
}
type Name = String
type Salary = Float

-- Some employees.
-- We don't have to use the selectors of the record type.
-- That is, we can also continue in a position-oriented fashion.
e1 = Employee { getEmployeeName = "Max", getSalary = 42 }
e2 = Employee "Sean" 66
e3 = Employee "Nina" 77

-- The same departments as before.
-- We are too lazy to rewrite the code to record syntax.
d1 = Department "Haskell" (Just e1) [] []
d2 = Department "C++" Nothing [e2] [d21]
d21 = Department "C++ Vx" Nothing [e3] []

-- Sample companies as in previous versions
sampleCompany1, sampleCompany2 :: Company
sampleCompany1 = FlatCompany [e1, e2, e3]
sampleCompany2 = HiearchicalCompany [d1, d2]

-- In the following code, we make use of selectors where possible.
total :: Company -> Float
total (FlatCompany es) = totalEs es
total (HiearchicalCompany ds) = totalDs ds

totalEs :: [Employee] -> Salary
totalEs = sum . map getSalary

totalDs :: [Department] -> Salary
totalDs = sum . map totalD

totalD :: Department -> Salary
totalD d = totalM (getManager d) + totalEs (getEmployees d) + totalDs (getSubDepartments d)
  where
    totalM :: Maybe Employee -> Salary
    totalM = maybe 0 getSalary
