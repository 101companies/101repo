using System.Collections.Generic;

namespace csharpBaseline.CompanyModel
{
    public class Company
    {
        public Company()
        {
            Departments = new List<Department>();
        }
        public string Name { get; set; }
        public List<Department> Departments { get; set; }

        public void CutSalaries()
        {
            foreach (var dept in Departments)
            {
                   dept.Cut(); 
            }
        }

        public decimal TotalSalaries
        {
            get
            {
                decimal total = 0;
                foreach (var dept in Departments)
                {
                    total += dept.Total;
                }

                return total;
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

            return ((c1.Name == Name) && (c1.TotalSalaries == TotalSalaries));
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
