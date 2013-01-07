module Company where

type Company = (Name, [Department])
type Department = (Name, Manager, [Employee])
type Employee = (Name, Address, Salary)
type Manager = Employee
type Name = String
type Address = String
type Salary = Float
