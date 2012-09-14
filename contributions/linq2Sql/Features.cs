using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace linq2Sql
{
    public static class Features
    {
        public static decimal Total(this CompanyDataClassesDataContext company)
        {
            var res = company.Employees.Sum(emp => emp.Salary);
            if (res != null) return (decimal)res;

            return 0M;
        }

        public static void Cut(this CompanyDataClassesDataContext company)
        {
            foreach (var employee in company.Employees)
            {
                employee.Salary /= 2;
            }
            company.SubmitChanges();
        }

        public static int Depth(this Department department)
        {
            var depth = 1;
            if (department.Departments.Count > 0)
            {
                depth += 1;
                foreach (var subUnit in department.Departments.ToList())
                {
                    depth += subUnit.Depth();
                    return depth;
                }
            }

            return depth;
        }
    }
}
