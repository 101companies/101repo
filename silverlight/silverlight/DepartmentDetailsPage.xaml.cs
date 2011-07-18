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
            var departmentId = "";
            if (NavigationContext.QueryString.TryGetValue("id", out departmentId))
            {
                var client = new CompanyServiceClient();
                client.GetDepartmentCompleted += (s, ea) => DataContext = ea.Result; ;
                client.GetDepartmentAsync(departmentId);
            }
        }

        private void Button1Click(object sender, RoutedEventArgs e)
        {
            var dept = DataContext as DepartmentDto;
            if (dept == null) return;
            
            var client = new CompanyServiceClient();
            client.CutDeptCompleted += (s, ea) => txtTotal.Text = (dept.Total / 2).ToString();

            client.CutDeptAsync(dept);
        }
    }
}
