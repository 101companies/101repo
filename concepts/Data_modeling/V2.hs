{-

V2: Flat companies versus companies with departments.
Each department has a manager (an employee) and any number of (other) employees.
We put to work the Either type constructor for modeling different company shapes.

-}

type Company = Either [Employee] [Department]
type Employee = (String, Float)
type Department = (String, Employee, [Employee])

-- The same employees as before
e1 = ("Max", 42)
e2 = ("Nina", 77)
e3 = ("Sean", 66)

-- Some departments are introduced.
d1 = ("Haskell", e1, [])
d2 = ("C++", e2, [e3])

-- A flat company with just a list of employees
sampleCompany1 :: Company
sampleCompany1 = Left [e1, e2, e3]

-- A company with two departments
sampleCompany2 :: Company
sampleCompany2 = Right [d1, d2]

-- Totaling companies has to handle two cases now!
total :: Company -> Float
{-
-- More basic code shown for comparison
total (Left es) = totalEs es
total (Right ds) = totalDs ds
-}
total = either totalEs totalDs

-- Employees are totaled as in the previous version.
totalEs :: [Employee] -> Float
{-
-- More basic code shown for comparison
totalEs [] = 0
totalEs ((_, s):es) = s + totalEs es
-}
totalEs = sum . map snd

-- This is the new code for totaling departments.
totalDs :: [Department] -> Float
{-
-- More basic code shown for comparison
totalDs [] = 0
totalDs ((_, (_, s), es):ds) = s + totalEs es + totalDs ds
-}
totalDs = sum . map totalD
  where
    totalD :: Department -> Float
    totalD (_, (_, s), es) = s + totalEs es
