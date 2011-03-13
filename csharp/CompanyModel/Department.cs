using System.Collections.Generic;

namespace csharpBaseline.CompanyModel
{
    public class Department
    {
        public Department()
        {
            SubUnits = new List<Department>();
            Employees = new List<Employee>();
        }

        public Department(string name, Employee manager) : this()
        {
            Name = name;
            Manager = manager;
        }

        public string Name { get; set; }
        public Employee Manager { get; set; }
        public List<Employee> Employees { get; set; }
        public List<Department> SubUnits { get; set; }

        /// <summary>
        /// Total all salaries in a department and subdepartments. 
        /// </summary>
        public decimal Total
        {
            get
            {
                var total = Manager.Salary;
                
                // calculate total across sub units
                foreach (var department in SubUnits)
                {
                    total += department.Total;
                }

                //add current division's employees' salaries to the total
                foreach (var employee in Employees)
                {
                    total += employee.Salary;
                }

                return total;
            }
        }

        /// <summary>
        /// Cut all salaries in half in department and subdepartments. 
        /// </summary>
        public void Cut()
        {
            foreach (var department in SubUnits)
            {
                department.Cut();
            }

            Manager.Salary /= 2;

            foreach (var employee in Employees)
            {
                if (employee.Salary != 0) employee.Salary /= 2;
            }
        }

        /// <summary>
        /// Determine depth of department nesting. 
        /// </summary>
        public int Depth
        {
            get
            {
                var depth = 0;
                if (SubUnits.Count > 0)
                {
                    depth += 1;
                    foreach (var subUnit in SubUnits)
                    {
                        depth += subUnit.Depth;
                        return depth;
                    }
                }

                return depth;
            }
        }

        public override bool Equals(object obj)
        {
            if (GetType() != obj.GetType()) return false;

            var c1 = obj as Department;
            if (c1 == null) return false;

            foreach (var employee in Employees)
            {
                if (!c1.Employees.Contains(employee)) return false;
            }
            foreach (var subUnit in SubUnits)
            {
                if (c1.SubUnits.Contains(subUnit)) return false;
            }
            return ((c1.Name == Name) && (c1.Manager.Equals(Manager)));
        }

        public override int GetHashCode()
        {
            unchecked
            {
                int result = (Name != null ? Name.GetHashCode() : 0);
                result = (result*397) ^ (Manager != null ? Manager.GetHashCode() : 0);
                result = (result*397) ^ (Employees != null ? Employees.GetHashCode() : 0);
                result = (result*397) ^ (SubUnits != null ? SubUnits.GetHashCode() : 0);
                return result;
            }
        }
    }
}
