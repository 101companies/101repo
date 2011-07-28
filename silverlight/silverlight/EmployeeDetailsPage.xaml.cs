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
    public partial class EmployeeDetailsPage : Page
    {
        public EmployeeDetailsPage()
        {
            InitializeComponent();
        }

        // Executes when the user navigates to this page.
        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            var employeeId = "";
            if (NavigationContext.QueryString.TryGetValue("id", out employeeId))
            {
                var client = new CompanyServiceClient();
                client.GetEmployeeCompleted += (s, ea) => DataContext = ea.Result;
                client.GetEmployeeAsync(Guid.Parse(employeeId));
            }
        }
    }
}
