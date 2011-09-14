using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public partial class Company
{
    public void Cut()
    {
        foreach (var dept in Department)
        {
            dept.Cut();
        }
    }

    public double Total
    {
        get
        {
             return Department.Sum(dept => dept.Total);
        }
    }
}

public partial class Department
{
    /// <summary>
    /// Total all salaries in a department and subdepartments. 
    /// </summary>
    public double Total
    {
        get
        {
            var s = Manager.Salary;
            if(Department1 != null)
            {
                s += Department1.Sum(department => department.Total);
            }
            if(Employee != null)
            {
                s += Employee.Sum(e => e.Salary);
            }

            return s;
        }
    }

    /// <summary>
    /// Cut all salaries in half in department and subdepartments. 
    /// </summary>
    public void Cut()
    {
        foreach (var department in Department1)
        {
            department.Cut();
        }

        Manager.Salary /= 2;

        foreach (var emp in Employee.Where(e => e.Salary != 0.0))
        {
            emp.Salary /= 2;
        }
    }
}
