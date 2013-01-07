module Company where

data Company = Company Name [Department]
data Department = Department Name Manager [Department] [Employee]
data Employee = Employee Name Address Salary
type Manager = Employee
type Name = String
type Address = String
type Salary = Float

