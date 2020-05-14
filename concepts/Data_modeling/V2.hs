type Company = Either [Employee] [Department]
type Department = (String, Employee, [Employee])
type Employee = (String, Float)
