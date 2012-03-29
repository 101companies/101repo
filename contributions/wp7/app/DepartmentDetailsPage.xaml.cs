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
using Microsoft.Phone.Controls;
using silverlightClassLibrary.CompanyModel;

namespace Wp7
{
    public partial class DepartmentDetailsPage : PhoneApplicationPage
    {
        // Constructor
        public DepartmentDetailsPage()
        {
            InitializeComponent();

            this.Loaded += DepartmentDetailsPageLoaged;
        }

        // When page is navigated to set data context to selected item in list
        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            string selectedDeptId = "";
            if (NavigationContext.QueryString.TryGetValue("selectedItem", out selectedDeptId))
            {
                var dept = App.ViewModel.AllDepartments.Where(d => d.Id.ToString() == selectedDeptId).First();
                DataContext = dept;
            }
        }

        private void DepartmentDetailsPageLoaged(object sender, RoutedEventArgs e)
        {
            var dept = (Department) DataContext;

            dept.PropertyChanged += (s, ea) =>
            {
                if (ea.PropertyName == "Total")
                {
                    txtTotal.Text = dept.Total.ToString();
                }
            };

            txtTotal.Text = dept.Total.ToString();
        }

        private void EmployeesListBoxSelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            var emp = (Employee)EmployeesListBox.SelectedItem;

            if (emp == null) return;
            
            NavigationService.Navigate(new Uri("/EmployeeDetailsPage.xaml?selectedItem=" + emp.Id, UriKind.Relative));

            // Reset selected index to -1 (no selection)
            //EmployeesListBox.SelectedIndex = -1;
        }

        private void SubDepartmentsListBoxSelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            var dept = (Department)SubDepartmentsListBox.SelectedItem;
            if(dept == null) return;
            
            NavigationService.Navigate(new Uri("/DepartmentDetailsPage.xaml?selectedItem=" + dept.Id, UriKind.Relative));

            // Reset selected index to -1 (no selection)
            //SubDepartmentsListBox.SelectedIndex = -1;
        }

        private void CutSalariesClick(object sender, EventArgs e)
        {
            App.ViewModel.Company.Cut();
        }
    }
}