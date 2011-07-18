using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using csharpBaseline.CompanyModel;

namespace csharpBaseline
{
    public class CompanyRepository
    {
        public static IList<T> Find<T>(Func<T, bool> filter) where T : class
        {
            if (typeof(T) == typeof(Department))
            {
                return AllDepartments.Where(department => filter(department as T)).ToList() as IList<T>;
            }
            if(typeof(T) == typeof(Employee))
            {
                return AllEmployees.Where(empl => filter(empl as T)).ToList() as IList<T>;
            }

            throw new NotSupportedException("Type not supported");
        }

        private static IEnumerable<Department> AllDepartments
        {
            get
            {
                var departments = GetAllDepartments(CreateInMemoryModel().Departments);
                return departments;
            }
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

        private static IEnumerable<Employee> AllEmployees
        {
            get
            {
                var empl = new List<Employee>();
                foreach (var dept in GetAllDepartments(CreateInMemoryModel().Departments))
                {
                    empl.Add(dept.Manager);
                    empl.AddRange(dept.Employees);
                }

                return empl;
            }
        }
        
        public static Company CreateInMemoryModel()
        {
            var c = new Company { Name = "meganalysis", Id = Guid.Parse("4B9FE87D-76AF-417E-AFE7-859DAFE6AB9B") };
            c.Departments.Add(new Department("Research",
                                             new Employee(
                                                 new Person("Craig") { Address = "Redmond" }) { Salary = 123456, Id = Guid.Parse("1576ED24-2E80-4618-81D9-4C0B3882D8E8") })
            {
                Id = Guid.Parse("1576ED24-2E80-4618-81D9-4C0B3882D8E8"),

                Employees = new List<Employee>
                { 
                    new Employee(new Person("Erik"){Address = "Utrecht"}) { Salary = 12345, Id = Guid.Parse("E33B78A6-A951-4DBD-8C82-9199DB67113E")}, 
                    new Employee(new Person("Ralf"){Address = "Koblenz"}) { Salary = 1234, Id = Guid.Parse("AB40BDAC-E32D-4366-9875-B27B78482B64")} 
                }
            });

            c.Departments.Add(new Department("Development", new Employee(new Person("Ray") { Address = "Redmond" }) { Salary = 234567, Id = Guid.Parse("4229DD6E-39A1-4FDA-89AC-17C7048290F7") })
            {
                Id = Guid.Parse("FA11B873-A2F7-4AA0-9B79-2908EE5729E5"),
                SubDepartments = new List<Department>
                               {
                                   new Department("Dev1", new Employee(new Person("Klaus") { Address = "Boston" }) { Salary = 23456, Id = Guid.Parse("AD112D66-7AC5-4CA3-AFF8-1045B0533B54")})
                                       {
                                           Id = Guid.Parse("A4DC6AC2-70E7-448D-86F4-39A1D6784C69"),
                                           SubDepartments = new List<Department>
                                                          {
                                                             new Department("Dev 1.1", new Employee(new Person("Karl"){Address = "Riga"}){Salary = 2345, Id = Guid.Parse("DDC2AC74-5BB0-4C14-A4E3-071C47579E23")})
                                                                 {
                                                                     Id = Guid.Parse("A4DC6AC2-70E7-448D-86F4-39A1D6784C69"),
                                                                     Employees = new List<Employee>
                                                                                     {
                                                                                         new Employee(new Person("Joe"){Address = "Wifi City"}){Salary = 2344, Id = Guid.Parse("0EDFB6FC-FCAA-4479-A711-DBC677EF7097")}
                                                                                     }
                                                                 } 
                                                          }
                                       }
                               }
            });

            return c;
        }
    }
}
