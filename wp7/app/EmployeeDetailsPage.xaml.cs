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
using Microsoft.Phone.Controls;
using silverlightClassLibrary.CompanyModel;

namespace Wp7
{
    public partial class EmployeeDetailsPage : PhoneApplicationPage
    {
        public EmployeeDetailsPage()
        {
            InitializeComponent();

            this.Loaded += EmployeeDetailsPageLoaged;
        }

        private void EmployeeDetailsPageLoaged(object sender, RoutedEventArgs e)
        {
            var empl = (Employee)DataContext;
            empl.PropertyChanged += (s, ea) =>
            {
                if (ea.PropertyName == "Salary")
                {
                    txtSalary.Text = empl.Salary.ToString();
                }
            };
        }


        // When page is navigated to set data context to selected item in list
        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            string employeeId = "";
            if (NavigationContext.QueryString.TryGetValue("selectedItem", out employeeId))
            {
                var employee = App.ViewModel.AllEmployees.Where(empl => empl.Id.ToString() == employeeId).First();
                DataContext = employee;
                PageTitle.Text = employee.Person.Name;
            }
        }

        private void CutSalaryClick(object sender, EventArgs e)
        {
            var empl = (Employee) DataContext;
            empl.Cut();
        }
    }
}