using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using System.Windows.Navigation;
using silverlight.CompanyServiceReference;

namespace silverlight
{
    public partial class DepartmentDetailsPage : Page
    {
        public DepartmentDetailsPage()
        {
            InitializeComponent();
        }

        // Executes when the user navigates to this page.
        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            string departmentId = "";
            if (NavigationContext.QueryString.TryGetValue("selectedItem", out departmentId))
            {
                var client = new CompanyServiceClient();
                client.GetDepartmentCompleted += client_GetDepartmentCompleted;
                client.GetDepartmentAsync(departmentId);
            }
        }

        void client_GetDepartmentCompleted(object sender, GetDepartmentCompletedEventArgs e)
        {
            DataContext = e.Result;
        }
    }
}
