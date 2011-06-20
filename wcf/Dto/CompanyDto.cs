using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace wcf.Dto
{
    [DataContract]
    public class CompanyDto
    {
        [DataMember]
        public Guid Id { get; set; }

        [DataMember]
        public string Name { get; set; }

        [DataMember]
        public List<DepartmentDto> Departments { get; set; }

        [DataMember]
        public decimal Total { get; set; }
    }
}