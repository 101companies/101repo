using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Activation;
using System.ServiceModel.Web;
using System.Text;
using csharpBaseline;
using csharpBaseline.CompanyModel;

namespace wcfRest
{
    // Start the service and browse to http://<machine_name>:<port>/CompanyService/help to view the service's generated help page
    // NOTE: By default, a new instance of the service is created for each call; change the InstanceContextMode to Single if you want
    // a single instance of the service to process all calls.	
    [ServiceContract]
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    [ServiceBehavior(InstanceContextMode = InstanceContextMode.PerCall)]
    // NOTE: If the service is renamed, remember to update the global.asax.cs file
    public class CompanyService
    {
        // TODO: Implement the collection resource that will contain the SampleItem instances
        private Company Company
        {
            get { return CompanyRepository.CreateInMemoryModel(); }
        }

        [WebGet(UriTemplate = "", ResponseFormat = WebMessageFormat.Json)]
        public Company GetCompany()
        {
            return Company;
        }

        [WebGet(UriTemplate = "departments")]
        public List<Department> GetDepartments()
        {
            return Company.Departments;
        }
        
        [WebGet(UriTemplate = "{id}")]
        public SampleItem Get(string id)
        {
            // TODO: Return the instance of SampleItem with the given id
            throw new NotImplementedException();
        }

        [WebInvoke(UriTemplate = "{id}", Method = "PUT")]
        public SampleItem Update(string id, SampleItem instance)
        {
            // TODO: Update the given instance of SampleItem in the collection
            throw new NotImplementedException();
        }

        [WebInvoke(UriTemplate = "{id}", Method = "DELETE")]
        public void Delete(string id)
        {
            // TODO: Remove the instance of SampleItem with the given id from the collection
            throw new NotImplementedException();
        }

    }
}
