module Company where

type Company = (Name, [Dept])
data Dept = Dept Name Manager [SubUnit]
 deriving (Eq, Read, Show)
type Manager = Employee
data Employee = Employee Name Address Salary
 deriving (Eq, Read, Show)
data SubUnit = PU Employee | DU Dept
 deriving (Eq, Read, Show)
type Name = String
type Address = String
type Salary = Float
