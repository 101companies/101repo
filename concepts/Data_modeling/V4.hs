-- V4: Making department manager optional
type Company = Either [Employee] [Department]
type Employee = (Name, Salary)
type Department = (Name, Manager, [Employee])
type Manager = Maybe Employee
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
    d1 = ("Haskell", m1, [])
    d2 = ("C++", m2, [e2, e3])
    m1 = Just e1
    m2 = Nothing

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
totalDs ((_, m, es):ds) = totalM m + totalEs es + totalDs ds
-}
totalDs = sum . map totalD

totalD :: Department -> Float
totalD (_, m, es) = totalM m + totalEs es

totalM :: Manager -> Float
{-
-- More basic code shown for comparison
totalM Nothing = 0
totalM (Just (_, s)) = s
-}
totalM = maybe 0 snd
