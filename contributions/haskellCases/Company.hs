module Company where

data Company = Company Name [Department]
 deriving (Eq, Read, Show)
data Department = Department Name Manager [SubUnit]
 deriving (Eq, Read, Show)
data Employee = Employee Name Address Salary
 deriving (Eq, Read, Show)
data SubUnit = EUnit Employee | DUnit Department
 deriving (Eq, Read, Show)
type Manager = Employee
type Name = String
type Address = String
type Salary = Float
