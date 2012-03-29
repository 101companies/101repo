module Company where

type Company = (Name, [Department])
data Department = Department Name Manager [SubUnit]
 deriving (Eq, Read, Show)
type Manager = Employee
data Employee = Employee Name Address Salary
 deriving (Eq, Read, Show)
data SubUnit = EUnit Employee | DUnit Department
 deriving (Eq, Read, Show)
type Name = String
type Address = String
type Salary = Float
