{-

V1: A company as a list of employees.
This is our baseline model which we are going to enhance in many different ways.
These enhancements allow us to demonstrate many aspects of data modeling in Haskell.

-}

type Company = [Employee]
type Employee = (String, Float)

-- Some employees
e1 = ("Max", 42)
e2 = ("Nina", 77)
e3 = ("Sean", 66)

sampleCompany :: Company
sampleCompany = [e1, e2, e3]
 
total :: Company -> Float
{-
-- More basic code shown for comparison
total [] = 0
total ((_, s):es) = s + total es
-}
total = sum . map snd
