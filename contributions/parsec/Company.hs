module Company where

type Company = (Name, [Department])
data Department = Department Name Manager [SubUnit]
 deriving (Eq, Show)
type Manager = Employee
data Employee = Employee Name Address Salary
 deriving (Eq, Show)
data SubUnit = EUnit Employee | DUnit Department
 deriving (Eq, Show)
type Name = String
type Address = String
type Salary = Float
