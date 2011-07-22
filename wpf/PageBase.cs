using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;

namespace Wpf
{
    public abstract class PageBase : Page
    {
        public static readonly DependencyProperty WindowsTitleProperty = DependencyProperty.Register(
          "WindowsTitle",
          typeof(string),
          typeof(PageBase));

        public string WindowsTitle
        {
            get { return (string)GetValue(WindowsTitleProperty); }
            set { SetValue(WindowsTitleProperty, value); }
        }
    }
}
