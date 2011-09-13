using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public partial class company
{
    public void Cut()
    {
        foreach (var dept in department)
        {
            //dept.Cut();
        }
    }

    public double Total
    {
        get
        {
             return department.Sum(dept => dept.Total);
        }
    }
}

public partial class department
{
    /// <summary>
    /// Total all salaries in a department and subdepartments. 
    /// </summary>
    public double Total
    {
        get
        {
            // calculate total across sub units

            //add current division's employees' salaries to the total

            return manager.salary + department1.Sum(department => department.Total) +
                employee.Sum(e => e.salary);
        }
    }

    /// <summary>
    /// Cut all salaries in half in department and subdepartments. 
    /// </summary>
    public void Cut()
    {
        foreach (var department in department1)
        {
            department.Cut();
        }

        manager.salary /= 2;

        foreach (var emp in employee.Where(e => e.salary != 0.0))
        {
            emp.salary /= 2;
        }
    }
}
