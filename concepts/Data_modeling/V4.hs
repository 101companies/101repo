{-

V4: Making department manager optional.
Previously, each department had to have a manager.
In this new version, there is a choice.
We put to work the Maybe type constructor to this end.

-}

type Company = Either [Employee] [Department]
type Employee = (Name, Salary)
type Department = (Name, Manager, [Employee])
type Manager = Maybe Employee
type Name = String
type Salary = Float

-- The same employees as before
e1 = ("Max", 42)
e2 = ("Nina", 77)
e3 = ("Sean", 66)

-- One department with a manager, another one without
d1 = ("Haskell", Just e1, [])
d2 = ("C++", Nothing, [e2, e3])

-- Sample companies as in previous versions
sampleCompany1, sampleCompany2 :: Company
sampleCompany1 = Left [e1, e2, e3]
sampleCompany2 = Right [d1, d2]

total :: Company -> Salary
total = either totalEs totalDs

totalEs :: [Employee] -> Salary
totalEs = sum . map snd

totalDs :: [Department] -> Salary
totalDs = sum . map totalD
  where
    totalD :: Department -> Salary
    totalD (_, m, es) = totalM m + totalEs es
      where
        -- Totaling a manager means to process the maybe value.
        totalM :: Manager -> Salary
        {-
        -- More basic code shown for comparison
        totalM Nothing = 0
        totalM (Just (_, s)) = s
        -}
        totalM = maybe 0 snd
