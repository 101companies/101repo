using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;

namespace csharpLinqToXml
{
    public static class Features
    {
        public static XDocument Cut(XDocument xml)
        {
            foreach (var salary in xml.Descendants("Salary"))
            {
                salary.Value = (decimal.Parse(salary.Value)/2).ToString();
            }

            return xml;
        }

        public static decimal Total(XDocument xml)
        {
            return xml.Descendants("Salary").Sum(salary => decimal.Parse(salary.Value));
        }
    }
}
