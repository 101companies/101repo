using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using csharpBaseline.CompanyModel;
using NUnit.Framework;

namespace csharpBaseline.Tests
{
    [TestFixture]
    public class FeaturesTests
    {
        private static Company Company
        {
            get
            {
                return CompanyBuilder.CreateInMemoryModel();
            }
        }

        [Test]
        public void TotalTest()
        {
            var total = Company.Total;

            // http://sourceforge.net/apps/mediawiki/developers/index.php?title=101companies is used for a salary source
            Assert.AreEqual(123456 + 12345 + 1234 + 234567 + 23456 + 2345 + 2344, total);
        }

        [Test]
        public void CutTest()
        {
            var c = Company;
            var total = c.Total;
            c.Cut();
            var totalAfterCut = c.Total;
            Assert.AreEqual(total, totalAfterCut * 2);
        }

        [Test]
        public void DepthTest()
        {
            var c = Company;
            var devDept = c.Departments.Where(d => d.Name == "Development").First();
            Assert.AreEqual(3, devDept.Depth);
        }
    }
}
