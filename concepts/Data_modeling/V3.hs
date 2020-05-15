-- V3: Use of extra type synonyms for clarity
type Company = Either [Employee] [Department]
type Employee = (Name, Salary)
type Department = (Name, Manager, [Employee])
type Manager = Employee
type Name = String
type Salary = Float

-- Some employees
e1 = ("Max", 42)
e2 = ("Nina", 77)
e3 = ("Sean", 66)

sampleCompany1 :: Company
sampleCompany1 = Left [e1, e2, e3]

sampleCompany2 :: Company
sampleCompany2 = Right [d1, d2]
  where
    d1 = ("Haskell", e1, [])
    d2 = ("C++", e2, [e3])

total :: Company -> Float
{-
-- More basic code shown for comparison
total (Left es) = totalEs es
total (Right ds) = totalDs ds
-}
total = either totalEs totalDs

totalEs :: [Employee] -> Float
{-
-- More basic code shown for comparison
totalEs [] = 0
totalEs ((_, s):es) = s + totalEs es
-}
totalEs = sum . map snd

totalDs :: [Department] -> Float
{-
-- More basic code shown for comparison
totalDs [] = 0
totalDs ((_, (_, s), es):ds) = s + totalEs es + totalDs ds
-}
totalDs = sum . map totalD

totalD :: Department -> Float
totalD (_, (_, s), es) = s + totalEs es
