using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using csharpBaseline.CompanyModel;
using wcf.Dto;

namespace wcf
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ICompanyService" in both code and config file together.
    [ServiceContract]
    public interface ICompanyService
    {
        [OperationContract]
        CompanyDto GetCompany();

        [OperationContract]
        DepartmentDto GetDepartment(string id);

        [OperationContract]
        EmployeeDto GetEmployee(string id);
    }
}
