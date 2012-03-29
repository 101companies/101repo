using System;
using System.ServiceModel.Activation;
using System.Web;
using System.Web.Routing;

namespace wcfRest
{
    public class Global : HttpApplication
    {
        void Application_Start(object sender, EventArgs e)
        {
            RegisterRoutes();
        }

        private void RegisterRoutes()
        {
            // Edit the base address of CompanyService by replacing the "CompanyService" string below
            RouteTable.Routes.Add(new ServiceRoute("CompanyService", new WebServiceHostFactory(), typeof(CompanyService)));
        }
    }
}
