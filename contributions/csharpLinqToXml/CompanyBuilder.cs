using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using csharpBaseline.CompanyModel;

namespace csharpLinqToXml
{
    public class CompanyBuilder
    {
        /// <summary>
        /// Creates company from its XML representation using LINQ2XML for deserialization
        /// </summary>
        /// <returns>In memory company model</returns>
        public static Company CreateCompany(XDocument xmlDoc)
        {
            var company = new Company();
         
            if (xmlDoc.Root != null)
            {
                var name = xmlDoc.Root.Elements().Where(el => el.Name == "Name").First().Value;
                company.Name = name;
            }

            HandleDepartments(ref company, xmlDoc.Root);

            return company;
        }

        private static void HandleDepartments(ref Company c, XElement xml)
        {
            var xmlDepts = xml.Elements("Departments");
            foreach (var xElement in xmlDepts.Elements("Department"))
            {
                c.Departments.Add(HandleDepartment(xElement));
            }
        }

        private static Department HandleDepartment(XElement xml)
        {
            var d = new Department();
            var name = xml.Elements("Name").First().Value;
            d.Name = name;
            d.Manager = HandleEmployee(xml.Elements("Manager").FirstOrDefault());

            var xmlEmployees = xml.Elements("Employees");
            if (xmlEmployees.Elements().Count() > 0)
            {
                foreach (var xmlEmployee in xmlEmployees.Elements("Employee"))
                {
                    d.Employees.Add(HandleEmployee(xmlEmployee));
                }
            }

            var xmlSubUnits = xml.Elements("SubDepartments");
            if (xmlSubUnits.Elements().Count() > 0)
            {
                foreach (var xmlSubUnit in xmlSubUnits.Elements("Department"))
                {
                    d.SubDepartments.Add(HandleDepartment(xmlSubUnit));
                }
            }

            return d;
        }

        private static Employee HandleEmployee(XContainer xml)
        {
            var m = new Employee
                        {
                            Salary = decimal.Parse(xml.Elements("Salary").First().Value),
                            Person = HandlePerson(xml.Elements("Person").FirstOrDefault())
                        };
            return m;
        }

        private static Person HandlePerson(XContainer xml)
        {
            var p = new Person
                        {
                            Address = xml.Elements("Address").First().Value,
                            Name = xml.Elements("Name").First().Value
                        };

            return p;
        }
    }
}
