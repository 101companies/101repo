using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace linqToDataSet
{
    public static class Features
    {
        public static decimal Total()
        {
            var ds = new CompanyDataSet();
            var ed = new CompanyDataSetTableAdapters.EmployeeTableAdapter();
            ed.Fill(ds.Employee);
           
            var total = ds.Employee.Sum(e => e.Salary);
            return total;
        }

        public static void Cut()
        {
            var ds = new CompanyDataSet();
            var ed = new CompanyDataSetTableAdapters.EmployeeTableAdapter();
            ed.Fill(ds.Employee);

            foreach (var emp in ds.Employee)
            {
                emp.Salary /= 2;
            }

            ed.Update(ds);
        }
    }
}
