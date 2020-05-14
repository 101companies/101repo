data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
data Employee = Employee {
    getEmployeeName :: String,
    getSalary :: Float
}
data Department = Department {
    getDepartmentName :: String,
    getDepartmentUnits :: [DepartmentUnit]
}
data DepartmentUnit 
  = ManagerUnit Employee
  | EngineerUnit Employee
  | SubDepartmentUnit Department
