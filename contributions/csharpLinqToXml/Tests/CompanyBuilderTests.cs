using System.Xml.Linq;
using NUnit.Framework;

namespace csharpLinqToXml.Tests
{
    [TestFixture]
    public class CompanyBuilderTests
    {
        private static XDocument Xml
        {
            get { return XDocument.Load("company.xml"); }
        }
        [Test]
        public void CreateCompanyFromXml()
        {
            var c = CompanyBuilder.CreateCompany(Xml);
            Assert.AreEqual(123456 + 12345 + 1234 + 234567 + 23456 + 2345 + 2344,c.Total);
        }

        [Test]
        public void XmlOperationsTest()
        {
            var c = CompanyBuilder.CreateCompany(Xml);
            
            var total = Features.Total(Xml);
            Assert.AreEqual(c.Total, total);

            var newCompany = Features.Cut(Xml);
            var newTotal = Features.Total(newCompany);
            Assert.AreEqual(total, newTotal * 2);
        }
    }
}
