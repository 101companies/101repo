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
    /// <summary>
    /// Interaction logic for DepartmentDetailsPage.xaml
    /// </summary>
    public partial class DepartmentDetailsPage : PageBase
    {
        private readonly Guid _departmentId;

        public static readonly DependencyProperty TotalProperty = DependencyProperty.Register(
         "Total",
         typeof(decimal),
         typeof(DepartmentDetailsPage));

        public decimal Total
        {
            get { return (decimal)GetValue(TotalProperty); }
            set { SetValue(TotalProperty, value); }
        }

        public DepartmentDetailsPage(Guid deptId)
            : this()
        {
            _departmentId = deptId;
        }

        public DepartmentDetailsPage()
        {
            InitializeComponent();
            RegisterName("Window", this);
        }

        private void BtnCutClick(object sender, RoutedEventArgs e)
        {
            Features.CutSubDept(_departmentId);
            Total = Features.SubTotalForDept(_departmentId);
        }

        private void PageLoaded(object sender, RoutedEventArgs e)
        {
            var dda = new linqToDataSet.CompanyDataSetTableAdapters.DepartmentTableAdapter();
            var ds = new CompanyDataSet();
            dda.FillBy(ds.Department, _departmentId);

            var eda = new linqToDataSet.CompanyDataSetTableAdapters.EmployeeTableAdapter();
            eda.Fill(ds.Employee);
            var manager = ds.Employee.Where(emp => (emp.department_id == _departmentId) && emp.IsManager).Single();

            var pda = new linqToDataSet.CompanyDataSetTableAdapters.PersonTableAdapter();
            pda.FillBy(ds.Person, manager.person_id);

            var dept = ds.Department.Where(d => d.department_id == _departmentId).Single();
            WindowsTitle = dept.Name;

            Total = Features.SubTotalForDept(_departmentId);

            DataContext = new { Name = manager.PersonRow.Name };
        }
    }
}
