using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using linqToDataSet;

namespace Wpf
{
    public class EmployeeChangedEventArgs : EventArgs
    {
        public string Name { get; private set; }

        public EmployeeChangedEventArgs(string name)
        {
            Name = name;
        }

    }
    /// <summary>
    /// Interaction logic for EmployeeDetailsPage.xaml
    /// </summary>
    public partial class EmployeeDetailsPage : PageBase
    {
        private readonly Guid _employeeId;

        public EmployeeDetailsPage(Guid empId) : this()
        {
            _employeeId = empId;
        }

        public EventHandler<EmployeeChangedEventArgs> OnEmployeeChanged;
        public EmployeeDetailsPage()
        {
            InitializeComponent();
            RegisterName("Window", this);
        }

        private void PageLoaded(object sender, RoutedEventArgs e)
        {
            var eda = new linqToDataSet.CompanyDataSetTableAdapters.EmployeeTableAdapter();
            var ds = new CompanyDataSet();
            eda.FillBy(ds.Employee, _employeeId);

            var pda = new linqToDataSet.CompanyDataSetTableAdapters.PersonTableAdapter();
            pda.FillBy(ds.Person, ds.Employee.Single().person_id);

            var emp = ds.Employee.Single();
            var person = emp.PersonRow;

            WindowsTitle = person.Name;
            DataContext = new {Person = person, Employee = emp};
        }

        private void BtnSaveClick(object sender, RoutedEventArgs e)
        {
            dynamic ctx = DataContext;
            var person = (CompanyDataSet.PersonRow)ctx.Person;
            var emp = (CompanyDataSet.EmployeeRow)ctx.Employee;

            var eda = new linqToDataSet.CompanyDataSetTableAdapters.EmployeeTableAdapter();
            eda.Update(emp);
            
            var pda = new linqToDataSet.CompanyDataSetTableAdapters.PersonTableAdapter();
            pda.Update(person);

            if(OnEmployeeChanged != null)
            {
                OnEmployeeChanged(this, new EmployeeChangedEventArgs(person.Name));
            }
        }
    }
}
