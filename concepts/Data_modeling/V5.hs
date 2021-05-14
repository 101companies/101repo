{-

V5: Enabling nested department structure.
That is, departments may have sub-departments and so on.
We need to use an algebraic data type for departments now.
Until now we simply had a type synonym for departments.
However, type synonyms must not be recursive.

-}

type Company = Either [Employee] [Department]
type Employee = (Name, Salary)
data Department = Department Name Manager [Employee] [Department]
-- The following version does NOT work because of the recursive reference!
-- type Department = (Name, Manager, [Employee], [Department])
type Manager = Maybe Employee
type Name = String
type Salary = Float

-- The same employees as before
e1 = ("Max", 42)
e2 = ("Nina", 77)
e3 = ("Sean", 66)

-- Some departments
d1 = Department "Haskell" (Just e1) [] []
d2 = Department "C++" Nothing [e2] [d21]
d21 = Department "C++ Vx" Nothing [e3] []

-- Sample companies as in previous versions
sampleCompany1, sampleCompany2 :: Company
sampleCompany1 = Left [e1, e2, e3]
sampleCompany2 = Right [d1, d2]

total :: Company -> Salary
total = either totalEs totalDs

totalEs :: [Employee] -> Salary
totalEs = sum . map snd

-- The function for totaling departments is recursive, too!
totalDs :: [Department] -> Salary
totalDs = sum . map totalD
  where
    totalD :: Department -> Salary
    totalD (Department _ m es ds) = totalM m + totalEs es + totalDs ds
      where
        totalM :: Manager -> Salary
        totalM = maybe 0 snd
