{-

V3: Use of extra type synonyms for clarity.
That is, we clarify concepts of managers, names (of employees), and salaries.
Of course, much is left to be wanted.
For instance, we do not specify the unit (the currency) for salaries.
Further, the format / structure for employee names is not specified either.

-}

type Company = Either [Employee] [Department]
type Employee = (Name, Salary)
type Department = (Name, Manager, [Employee])
type Manager = Employee
type Name = String
type Salary = Float

{-

The rest of the code is identical to the previous version.
With one exception: We can use the type synonym Salary in function signatures for clarity.
The increased use of type synonyms does not imply any additional type checking.

-}

-- The same employees as before
e1 = ("Max", 42)
e2 = ("Nina", 77)
e3 = ("Sean", 66)

-- The same departments as before
d1 = ("Haskell", e1, [])
d2 = ("C++", e2, [e3])

sampleCompany1 :: Company
sampleCompany1 = Left [e1, e2, e3]

sampleCompany2 :: Company
sampleCompany2 = Right [d1, d2]

total :: Company -> Salary
total = either totalEs totalDs

totalEs :: [Employee] -> Salary
totalEs = sum . map snd

totalDs :: [Department] -> Salary
totalDs = sum . map totalD
  where
    totalD :: Department -> Salary
    totalD (_, (_, s), es) = s + totalEs es
