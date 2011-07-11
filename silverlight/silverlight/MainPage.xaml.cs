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
using System.Windows.Navigation;
using System.Windows.Shapes;
using silverlight.CompanyServiceReference;

namespace silverlight
{
    public partial class MainPage : UserControl
    {
        public MainPage()
        {
            InitializeComponent();
            this.Loaded += MainPageLoaded;
        }

        void MainPageLoaded(object sender, RoutedEventArgs e)
        {
            var client = new CompanyServiceClient();
            client.GetCompanyCompleted += ClientGetCompanyCompleted;
            client.GetCompanyAsync();
        }

        void ClientGetCompanyCompleted(object sender, GetCompanyCompletedEventArgs e)
        {
            var company = e.Result;
            treeCompany.ItemsSource = company.Departments.Select(d => new NameBinding { Name = d.Name, Url = new Uri("/DepartmentDetailsPage.xaml?selectedItem=" + d.Id, UriKind.Relative) }).ToList();
            DataContext = treeCompany.ItemsSource;
        }

        private void TreeCompanySelectedItemChanged(object sender, RoutedPropertyChangedEventArgs<object> e)
        {
            var node = e.NewValue as NameBinding;
            if (node == null)
            {
                return;
               // node = e.NewValue as 
            }
            ContentFrame.Navigate(node.Url);
        }
    }

    public class NameBinding
    {
        public string Name { get; set; }
        public Uri Url { get; set; }
    }
}
