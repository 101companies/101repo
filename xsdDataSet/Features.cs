using System;
using System.Data;

namespace xsdDataSet
{
    public class Features
    {
        public static Company Company
        {
            get
            {
                return new Company();
            }
        }

        public static decimal Total
        {
            get
            {
                decimal total = 0;
                foreach (DataRow row in Company.Employee.Rows)
                {
                    decimal val;
                    
                    if(Decimal.TryParse(row["Salary"].ToString(), out val))
                    {
                        total += val;
                    }
                }

                return total;
            }
        }
    }
}
