-- V6: Replacing Either by a problem-specific type
data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
type Employee = (Name, Salary)
data Department = Department Name Manager [Employee] [Department]
type Manager = Maybe Employee
type Name = String
type Salary = Float

-- Some employees
e1 = ("Max", 42)
e2 = ("Nina", 77)
e3 = ("Sean", 66)

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
totalEs = sum . map snd

totalDs :: [Department] -> Float
totalDs = sum . map totalD

totalD :: Department -> Float
totalD (Department _ m es ds) = totalM m + totalEs es + totalDs ds

totalM :: Manager -> Float
totalM = maybe 0 snd
