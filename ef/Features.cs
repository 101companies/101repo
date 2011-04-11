using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace csharpEntityFramework
{
    public static class Features
    {
        public static decimal Total(this CompanyDataContext company)
        {
            var res = company.Employees.Sum(emp => emp.Salary);
            if (res != null) return (decimal) res;

            return 0M;
        }

        public static void Cut(this CompanyDataContext company)
        {
            foreach (var employee in company.Employees)
            {
                employee.Salary /= 2;
            }
            company.SaveChanges();
        }

        public static int Depth(this Department department)
        {
                var depth = 0;
                if (department.SubUnits.Count > 0)
                {
                    depth += 1;
                    foreach (var subUnit in department.SubUnits.ToList())
                    {
                        depth += subUnit.Depth();
                        return depth;
                    }
                }

                return depth;
        }
    }
}
