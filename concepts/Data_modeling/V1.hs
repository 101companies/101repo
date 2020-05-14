type Company = [Employee]
type Employee = (String, Float)

sampleCompany :: Company
sampleCompany = [e1, e2, e3]
  where
    e1 = ("Max", 42)
    e2 = ("Nina", 77)
    e3 = ("Sean", 66)
 
total :: Company -> Float
total [] = 0
total ((_, s):es) = s + total es
