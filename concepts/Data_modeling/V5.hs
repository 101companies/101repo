type Company = Either [Employee] [Department]
type Employee = (Name, Salary)
data Department = Department Name Manager [Employee] [Department]
type Manager = Maybe Employee
type Name = String
type Salary = Float
