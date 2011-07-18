using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Activation;
using System.ServiceModel.Web;
using System.Text;
using System.Web;
using csharpBaseline;
using csharpBaseline.CompanyModel;
using wcf.Dto;

namespace wcf
{
    //TODO: check this issue http://stackoverflow.com/questions/5019798/aspnetcompatibilityrequirements-causes-wcf-web-service-to-block
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Required)]
    [ServiceBehavior(InstanceContextMode = InstanceContextMode.Single)]
    public class CompanyService : ICompanyService
    {
        private Company Company
        {
            get
            {
                if (HttpContext.Current.Session["company"] == null)
                {
                    HttpContext.Current.Session["company"] = CompanyRepository.CreateInMemoryModel();
                }

                return HttpContext.Current.Session["company"] as Company;
            }
        }

        private List<DepartmentDto> FillSubDepartments(Department d)
        {
            var res = new List<DepartmentDto>();

            foreach (var subDepartment in d.SubDepartments)
            {
                var subDept = new DepartmentDto();
                subDept.Id = subDepartment.Id;
                subDept.Name = subDepartment.Name;
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
                                                                                    Manager = new EmployeeDto
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

        public decimal CutDept(DepartmentDto dept)
        {
            var department = Company.AllDepartments.Where(d => d.Id == dept.Id).First();
            department.Cut();

            return department.Total;
        }

        public decimal CutEmpl(EmployeeDto emp)
        {
            return new decimal(0.0);
        }

        public decimal Cut(CompanyDto company)
        {
            Company.Cut();
            return Company.Total;
        }
    }
}
