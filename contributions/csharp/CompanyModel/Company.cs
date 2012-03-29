using System;
using System.Collections.Generic;
using System.Linq;

namespace csharpBaseline.CompanyModel
{
    public class Company
    {
        public Guid Id { get; set; }

        public Company()
        {
            Departments = new List<Department>();
            Id = Guid.NewGuid();
        }
        public string Name { get; set; }
        public List<Department> Departments { get; set; }

        public IEnumerable<Department> AllDepartments
        {
            get { return GetAllDepartments(Departments); }
        }

        private static IEnumerable<Department> GetAllDepartments(IEnumerable<Department> depts)
        {
            var allDepts = new List<Department>();

            foreach (var department in depts)
            {
                allDepts.Add(department);
                allDepts.AddRange(GetAllDepartments(department.SubDepartments));
            }

            return allDepts;
        }

        public void Cut()
        {
            foreach (var dept in Departments)
            {
                   dept.Cut(); 
            }
        }

        public decimal Total
        {
            get
            {
                return Departments.Sum(dept => dept.Total);
            }
        }

        public int Depth
        {
            get
            {
                var depth = 0;
                foreach (var department in Departments.Where(department => department.Depth > depth))
                {
                    depth = department.Depth;
                }

                return depth;
            }
        }

        public override bool Equals(object obj)
        {
            if(GetType() != obj.GetType()) return false;

            var c1 = obj as Company;
            if (c1 == null) return false;

            foreach (var department in Departments)
            {
                if (!c1.Departments.Contains(department)) return false;
            }

            return ((c1.Name == Name) && (c1.Total == Total));
        }

        public override int GetHashCode()
        {
            unchecked
            {
                return ((Name != null ? Name.GetHashCode() : 0) * 397) ^ (Departments != null ? Departments.GetHashCode() : 0);
            }
        }
    }
}
