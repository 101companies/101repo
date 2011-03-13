using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using csharpBaseline.CompanyModel;

namespace csharpBaseline
{
    public class CompanyBuilder
    {
        public static Company CreateInMemoryModel()
        {
            var c = new Company { Name = "meganalysis" };
            c.Departments.Add(new Department("Research",
                                             new Employee(
                                                 new Person("Craig") { Address = "Redmond" }) { Salary = 123456 })
            {
                Employees = new List<Employee>
                { 
                    new Employee(new Person("Erik"){Address = "Utrecht"}) { Salary = 12345 }, 
                    new Employee(new Person("Ralf"){Address = "Koblenz"}) { Salary = 1234 } 
                }
            });

            c.Departments.Add(new Department("Development", new Employee(new Person("Ray") { Address = "Redmond" }) { Salary = 234567 })
            {
                SubUnits = new List<Department>
                               {
                                   new Department("Dev1", new Employee(new Person("Klaus") { Address = "Boston" }) { Salary = 23456 })
                                       {
                                           SubUnits = new List<Department>
                                                          {
                                                             new Department("Dev 1.1", new Employee(new Person("Karl"){Address = "Riga"}){Salary = 2345})
                                                                 {
                                                                     Employees = new List<Employee>
                                                                                     {
                                                                                         new Employee(new Person("Joe"){Address = "Wifi City"}){Salary = 2344}
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
