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

namespace Wpf
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            //TODO: bind hierarchical data with infinite level of nesting
            // http://social.msdn.microsoft.com/forums/en-US/wpf/thread/3a319a26-a910-47ef-88eb-97af09e29082/
            // http://msdn.microsoft.com/en-us/library/system.windows.hierarchicaldatatemplate(vs.85).aspx
        }
    }
}
