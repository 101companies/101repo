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
    /// Interaction logic for Home.xaml
    /// </summary>
    public partial class Home : PageBase
    {
        public Home()
        {
            InitializeComponent();
            RegisterName("Window", this);
        }

        public static readonly DependencyProperty TotalProperty = DependencyProperty.Register(
            "Total",
            typeof(decimal),
            typeof(Home));

        public static readonly DependencyProperty CompanyNameProperty = DependencyProperty.Register(
           "CompanyName",
           typeof(string),
           typeof(Home));

        public decimal Total
        {
            get { return (decimal)GetValue(TotalProperty); }
            set { SetValue(TotalProperty, value); }
        }

        public string CompanyName
        {
            get { return (string)GetValue(CompanyNameProperty); }
            set { SetValue(CompanyNameProperty, value); }
        }


        private void BtnCutClick(object sender, RoutedEventArgs e)
        {
            Features.Cut();
            Total = Features.Total();
        }

        private void PageLoaded(object sender, RoutedEventArgs e)
        {
            var ds = new CompanyDataSet();
            var cda = new linqToDataSet.CompanyDataSetTableAdapters.CompanyTableAdapter();
            cda.Fill(ds.Company);

            CompanyName = ds.Company.First().Name;
            Total = Features.Total();

            WindowsTitle = CompanyName;
        }
    }
}
