data Company
  = FlatCompany [Employee]
  | HiearchicalCompany [Department]
data Employee = Employee {
    getEmployeeName :: String,
    getSalary :: Float
}
data Department = Department {
    getDepartmentName :: String,
    getManager :: Maybe Employee,
    getEmployees :: [Employee],
    getSubDepartments :: [Department]
}
