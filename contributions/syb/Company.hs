module Company where

data Company = Company Name [Department]
data Department = Department Name Manager [SubUnit]
data Employee = Employee Name Address Salary (Maybe Mentor)
data SubUnit = EUnit Employee | DUnit Department
type Manager = Employee
type Mentor = Name
type Name = String
type Address = String
type Salary = Float
