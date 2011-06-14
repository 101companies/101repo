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
using Microsoft.Phone.Controls;
using silverlightClassLibrary.CompanyModel;

namespace Wp7
{
    public partial class MainPage : PhoneApplicationPage
    {
        // Constructor
        public MainPage()
        {
            InitializeComponent();

            this.Loaded += MainPageLoaded;
        }

        // Handle selection changed on ListBox
        private void MainListBoxSelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            // If selected index is -1 (no selection) do nothing
            if (MainListBox.SelectedIndex == -1)
                return;

            var dept = (Department) MainListBox.SelectedItem;

            NavigationService.Navigate(new Uri("/DepartmentDetailsPage.xaml?selectedItem=" + dept.Id, UriKind.Relative)); 

            // Reset selected index to -1 (no selection)
            MainListBox.SelectedIndex = -1;
        }

        // Load data for the ViewModel Items
        private void MainPageLoaded(object sender, RoutedEventArgs e)
        {
            if (!App.ViewModel.IsDataLoaded)
            {
                App.ViewModel.LoadData();
                App.ViewModel.Company.PropertyChanged += (s, ea) =>
                                                             {
                                                                 if (ea.PropertyName == "Total")
                                                                 {
                                                                     txtTotal.Text = App.ViewModel.Company.Total.ToString();
                                                                 }
                                                             };

                PageTitle.Text = App.ViewModel.Name;
            }

            // Set the data context of the listbox control to the data
            DataContext = App.ViewModel;
            txtTotal.Text = App.ViewModel.Company.Total.ToString();
        }

        private void CutSalariesClick(object sender, EventArgs e)
        {
           App.ViewModel.Company.Cut();
        }
    }
}