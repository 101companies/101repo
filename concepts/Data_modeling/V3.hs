type Company = Either [Employee] [Department]
type Employee = (Name, Salary)
type Department = (Name, Manager, [Employee])
type Manager = Employee
type Name = String
type Salary = Float
