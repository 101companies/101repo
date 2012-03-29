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
    public partial class Home : Page
    {
        public Home()
        {
            InitializeComponent();
        }

        // Executes when the user navigates to this page.
        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            var client = new CompanyServiceClient();
            client.GetCompanyCompleted += client_GetCompanyCompleted;
            client.GetCompanyAsync();
        }

        void client_GetCompanyCompleted(object sender, GetCompanyCompletedEventArgs e)
        {
            DataContext = e.Result;
        }

        private void btnCut_Click(object sender, RoutedEventArgs e)
        {
            var client = new CompanyServiceClient();
            client.CutCompleted += (x, y) => txtTotal.Content = y.Result;
            client.CutAsync((CompanyDto)DataContext);
        }

    }
}
