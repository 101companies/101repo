{-

V6: Replacing Either by a problem-specific type.
Arguably, this improves clarity of the data model.

-}

data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
type Employee = (Name, Salary)
data Department = Department Name Manager [Employee] [Department]
type Manager = Maybe Employee
type Name = String
type Salary = Float

-- The same employees as before
e1 = ("Max", 42)
e2 = ("Nina", 77)
e3 = ("Sean", 66)

-- The same departments as before
d1 = Department "Haskell" (Just e1) [] []
d2 = Department "C++" Nothing [e2] [d21]
d21 = Department "C++ Vx" Nothing [e3] []

-- Sample companies as in previous versions
sampleCompany1, sampleCompany2 :: Company
sampleCompany1 = FlatCompany [e1, e2, e3]
sampleCompany2 = HiearchicalCompany [d1, d2]

-- We pattern match on the Company type instead of Either.
total :: Company -> Float
total (FlatCompany es) = totalEs es
total (HiearchicalCompany ds) = totalDs ds

{-

The rest of the code is identical to the previous version.

-}

totalEs :: [Employee] -> Salary
totalEs = sum . map snd

totalDs :: [Department] -> Salary
totalDs = sum . map totalD
  where
    totalD :: Department -> Salary
    totalD (Department _ m es ds) = totalM m + totalEs es + totalDs ds
      where
        totalM :: Manager -> Salary
        totalM = maybe 0 snd
