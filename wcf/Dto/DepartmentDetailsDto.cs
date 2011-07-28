using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace wcf.Dto
{
    [DataContract]
    public class DepartmentDetailsDto
    {
        [DataMember]
        public Guid Id { get; set; }

        [DataMember]
        public EmployeeDto Manager { get; set; }

        [DataMember]
        public string Name { get; set; }

        [DataMember]
        public decimal Total { get; set; }
    }
}