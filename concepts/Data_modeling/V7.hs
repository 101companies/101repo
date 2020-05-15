-- V7: Replacing a tuple type by problem-specific type
data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
-- data Employee = Employee String Float
data Employee = Employee {
    getEmployeeName :: String,
    getSalary :: Float
}
-- data Department = Department String (Maybe Employee) [Employee] [Department]
data Department = Department {
    getDepartmentName :: String,
    getManager :: Maybe Employee,
    getEmployees :: [Employee],
    getSubDepartments :: [Department]
}

-- Some employees
e1 = Employee { getEmployeeName = "Max", getSalary = 42 }
e2 = Employee "Sean" 66
e3 = Employee "Nina" 77

sampleCompany1 :: Company
sampleCompany1 = FlatCompany [e1, e2, e3]

sampleCompany2 :: Company
sampleCompany2 = HiearchicalCompany [d1, d2]
  where
    d1 = Department "Haskell" m1 [] []
    d2 = Department "C++" m2 [e2] [d21]
    d21 = Department "C++ Vx" m3 [e3] []
    m1 = Just e1
    m2 = Nothing
    m3 = Nothing

total :: Company -> Float
total (FlatCompany es) = totalEs es
total (HiearchicalCompany ds) = totalDs ds

totalEs :: [Employee] -> Float
totalEs = sum . map totalE

totalE :: Employee -> Float
totalE (Employee _ s) = s

totalDs :: [Department] -> Float
totalDs = sum . map totalD

totalD :: Department -> Float
totalD (Department _ m es ds) = totalM m + totalEs es + totalDs ds

totalM :: Maybe Employee -> Float
totalM = maybe 0 totalE
