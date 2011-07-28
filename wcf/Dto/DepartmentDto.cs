using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace wcf.Dto
{
    [DataContract]
    public class DepartmentDto
    {
        public DepartmentDto()
        {
            Details = new DepartmentDetailsDto();
        }

        [DataMember]
        public DepartmentDetailsDto Details { get; set; }

        [DataMember]
        public List<EmployeeDto> Employees { get; set; }

        [DataMember]
        public List<DepartmentDto> SubDepartments { get; set; }
    }
}