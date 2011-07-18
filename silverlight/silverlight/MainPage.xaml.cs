using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

        private void MainPageLoaded(object sender, RoutedEventArgs e)
        {
            var client = new CompanyServiceClient();
            client.GetCompanyCompleted += ClientGetCompanyCompleted;
            client.GetCompanyAsync();
        }

        private void ClientGetCompanyCompleted(object sender, GetCompanyCompletedEventArgs e)
        {
            var company = e.Result;
            ShowTree(company);
        }

        private void ShowTree(CompanyDto company)
        {
            var tvCompanyItem = new TreeViewItem
                                    {
                                        Header = company.Name
                                    };
            this.treeCompany.Items.Add(tvCompanyItem);

            foreach (var dept in company.Departments)
            {
                var tv = new TreeViewItem 
                {
                    Header = dept.Name, 
                    Tag = new Uri(string.Format(@"/DepartmentDetailsPage.xaml?id={0}", dept.Id), UriKind.Relative)
                };
                tvCompanyItem.Items.Add(tv);
                GetSubTree(ref tv, dept);
            }
        }

        private void GetSubTree(ref TreeViewItem iSubTree, DepartmentDto department)
        {
            var subItem = new TreeViewItem
                              {
                                  Header = department.Manager.Name,
                                  Tag = new Uri(string.Format(@"/EmployeeDetailsPage.xaml?id={0}", department.Manager.Id), UriKind.Relative)
                              };
            iSubTree.Items.Add(subItem);

            foreach (var employee in department.Employees)
            {
                subItem = new TreeViewItem
                              {
                                  Header = employee.Name,
                                  Tag = new Uri(string.Format(@"/EmployeeDetailsPage.xaml?id={0}", employee.Id), UriKind.Relative)
                              };
                iSubTree.Items.Add(subItem);
            }

            foreach (var subDept in department.SubDepartments)
            {
                subItem = new TreeViewItem
                              {
                                  Header = subDept.Name,
                                  Tag = new Uri(string.Format(@"/DepartmentDetailsPage.xaml?id={0}", subDept.Id), UriKind.Relative)
                              };
                iSubTree.Items.Add(subItem);
                GetSubTree(ref subItem, subDept);
            }
        }

        private void TreeCompanySelectedItemChanged(object sender, RoutedPropertyChangedEventArgs<object> e)
        {
            var uri = ((TreeViewItem)e.NewValue).Tag as Uri;

            if (uri == null)
            {
                uri = new Uri(@"/Home.xaml", UriKind.Relative);
            }

            ContentFrame.Navigate(uri);
        }
    }

    public class NameBinding
    {
        public string Name { get; set; }
        public Uri Url { get; set; }
    }

}
