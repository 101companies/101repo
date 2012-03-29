using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace linqToDataSet
{
    public static class Features
    {
        private static CompanyDataSet _dataSet;
        private static CompanyDataSet Ds
        {
            get { return _dataSet ?? (_dataSet = new CompanyDataSet()); }
        }
        
        public static decimal Total()
        {
            var ed = new CompanyDataSetTableAdapters.EmployeeTableAdapter();
            ed.Fill(Ds.Employee);
           
            var total = Ds.Employee.Sum(e => e.Salary);
            return total;
        }

        public static decimal SubTotalForDept(Guid deptId)
        {
            var dda = new CompanyDataSetTableAdapters.DepartmentTableAdapter();
            dda.Fill(Ds.Department);

            var eda = new CompanyDataSetTableAdapters.EmployeeTableAdapter();
            eda.Fill(Ds.Employee);

            var root = Ds.Department.Where(d => d.department_id == deptId).Single();
            var total = GetSubDeptsTotal(root, root.GetEmployeeRows().Sum(er => er.Salary));

            return total;
        }

        public static void CutSubDept(Guid deptId)
        {
            var dda = new CompanyDataSetTableAdapters.DepartmentTableAdapter();
            dda.Fill(Ds.Department);

            var eda = new CompanyDataSetTableAdapters.EmployeeTableAdapter();
            eda.Fill(Ds.Employee);

            var root = Ds.Department.Where(d => d.department_id == deptId).Single();
            foreach (var employeeRow in root.GetEmployeeRows())
            {
                employeeRow.Salary /= 2;
            }

            CutSubDept(root);
            eda.Update(Ds);
        }

        private static void CutSubDept(CompanyDataSet.DepartmentRow parent)
        {
            var subDepts = Ds.Department.Where(d => (d.Isparent_idNull() == false) && (d.parent_id == parent.department_id));
            foreach (var subDept in subDepts)
            {
                foreach (var employeeRow in subDept.GetEmployeeRows())
                {
                    employeeRow.Salary /= 2;
                }

                CutSubDept(subDept);
            }
        }

        private static decimal GetSubDeptsTotal(CompanyDataSet.DepartmentRow parent, decimal total)
        {
            var subDepts = Ds.Department.Where(d => (d.Isparent_idNull() == false) && (d.parent_id == parent.department_id));
            foreach (var dept in subDepts)
            {
                total += dept.GetEmployeeRows().Sum(er => er.Salary);
                total += GetSubDeptsTotal(dept, total);
            }

            return total;
        }

        public static void Cut()
        {
            var ed = new CompanyDataSetTableAdapters.EmployeeTableAdapter();
            ed.Fill(Ds.Employee);

            foreach (var emp in Ds.Employee)
            {
                emp.Salary /= 2;
            }

            ed.Update(Ds);
        }
    }
}
