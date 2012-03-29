using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace xsdClasses
{
    public static class Features
    {
        public static double Total(Company company)
        {
            return company.TopLevelDepartment.Sum(dept => Total(dept));
        }

        public static void Cut(Company company)
        {
            foreach (var dept in company.TopLevelDepartment)
            {
                Cut(dept);
            }
        }

        public static double Total (Department department)
        {
            var s = department.Manager.Salary;
            if (department.SubDepartment != null)
            {
                s += department.SubDepartment.Sum(d => Total(d));
            }
            if (department.Employee != null)
            {
                s += department.Employee.Sum(e => e.Salary);
            }

            return s;
        }

        public static void Cut(Department department)
        {
            foreach (var dept in department.SubDepartment)
            {
                Cut(dept);
            }

            department.Manager.Salary /= 2;

            foreach (var emp in department.Employee.Where(e => e.Salary != 0.0))
            {
                emp.Salary /= 2;
            }
        }
    }
}
