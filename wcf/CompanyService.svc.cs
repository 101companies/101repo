using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using csharpBaseline;
using csharpBaseline.CompanyModel;
using wcf.Dto;

namespace wcf
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "CompanyService" in code, svc and config file together.
    public class CompanyService : ICompanyService
    {
        private Company _company;
        private Company Company
        {
            get { return _company ?? (_company = CompanyRepository.CreateInMemoryModel()); }
        }

        private List<DepartmentDto> FillSubDepartments(Department d)
        {
            var res = new List<DepartmentDto>();

            foreach (var subDepartment in d.SubDepartments)
            {
                var subDept = new DepartmentDto();
                subDept.Id = subDepartment.Id;
                subDept.Manager = new EmployeeDto
                                      {
                                          Address = subDepartment.Manager.Person.Address,
                                          Id = subDepartment.Manager.Id,
                                          Name = subDepartment.Manager.Person.Name,
                                          Salary = subDepartment.Manager.Salary
                                      };
                subDept.Employees = subDepartment.Employees.Select(e =>
                        new EmployeeDto
                            {
                                Id = e.Id,
                                Address = e.Person.Address,
                                Name = e.Person.Name,
                                Salary = e.Salary
                            }).ToList();

                subDept.SubDepartments = FillSubDepartments(subDepartment);
                res.Add(subDept);
            }

            return res;
        }

        public CompanyDto GetCompany()
        {
            var dto = new CompanyDto
                          {
                              Id = Company.Id,
                              Name = Company.Name,
                              Departments = Company.Departments.Select(d => new DepartmentDto
                                                                                {
                                                                                    Id = d.Id,
                                                                                    Name = d.Name,
                                                                                    Employees = d.Employees.Select(e => new EmployeeDto
                                                                                    {
                                                                                        Id = e.Id,
                                                                                        Address = e.Person.Address,
                                                                                        Name = e.Person.Name,
                                                                                        Salary = e.Salary
                                                                                    }).ToList(),
                                                                                    SubDepartments = FillSubDepartments(d),
                                                                                    Manager = new EmployeeDto()
                                                                                                  {
                                                                                                      Id = d.Manager.Id,
                                                                                                      Address = d.Manager.Person.Address,
                                                                                                      Name = d.Manager.Person.Name,
                                                                                                      Salary = d.Manager.Salary
                                                                                                  }
                                                                                }).ToList(),
                              Total = Company.Total
                          };

            return dto;
        }

        public DepartmentDto GetDepartment(string id)
        {
            var dept = CompanyRepository.Find<Department>(d => d.Id.ToString() == id).First();
            var dto = new DepartmentDto
                          {
                              Id = dept.Id,
                              Name = dept.Name,
                              Manager = new EmployeeDto()
                                            {
                                                Address = dept.Manager.Person.Address,
                                                Id = dept.Manager.Id,
                                                Name = dept.Manager.Person.Name,
                                                Salary = dept.Manager.Salary
                                            },
                              Total = dept.Total,
                              SubDepartments = FillSubDepartments(dept),
                              Employees = dept.Employees.Select(e => new EmployeeDto { Id = e.Id, Address = e.Person.Address, Name = e.Person.Name, Salary = e.Salary }).ToList()
                          };

            return dto;
        }

        public EmployeeDto GetEmployee(string id)
        {
            var empl = CompanyRepository.Find<Employee>(d => d.Id.ToString() == id).First();
            var dto = new EmployeeDto
                          {
                              Id = empl.Id,
                              Name = empl.Person.Name,
                              Salary = empl.Salary,
                              Address = empl.Person.Address
                          };

            return dto;
        }
    }
}
