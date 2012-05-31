module Company where

data Company = Company Name [Department]
    deriving (Eq, Show)
data Department = Department Name Manager [Department] [Employee]
 deriving (Eq, Show)
type Manager = Employee
data Employee = Employee Name Address Salary
 deriving (Eq, Show)
type Name = String
type Address = String
type Salary = Float
