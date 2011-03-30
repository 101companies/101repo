using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;

namespace csharpEntityFramework.Tests
{
    [TestFixture]
    public class FeaturesTests
    {
        [Test]
        public void TotalTest()
        {
            /*NOTE: please recreate database before running this test as soon as "Cut" operation modifies the data and total reduced
             every time you run the test, so we can't expect the same total */

            var company = new CompanyDataContext();
            var total = company.Total();

            // http://sourceforge.net/apps/mediawiki/developers/index.php?title=101companies is used for a salary source
            Assert.AreEqual(123456 + 12345 + 1234 + 234567 + 23456 + 2345 + 2344, total);

            company.Cut();
            var afterCut = company.Total();
            Assert.AreEqual(total / 2, afterCut);
        }

        [Test]
        public void DepthTest()
        {
            var ctx = new CompanyDataContext();
            var devDept = ctx.Departments.Where(d => d.Name == "Development").First();
            Assert.AreEqual(2, devDept.Depth());
        }
    }
}
