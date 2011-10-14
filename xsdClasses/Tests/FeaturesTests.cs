using System.IO;
using System.Xml.Serialization;
using NUnit.Framework;

namespace xsdClasses.Tests
{
    [TestFixture]
    public class FeaturesTests
    {
        private Company Company
        {
            get
            {
                using (var fs = new FileStream(@"../../xsd/sampleCompany.xml", FileMode.Open))
                {
                    var xs = new XmlSerializer(typeof(Company));
                    var company = xs.Deserialize(fs) as Company;
                    return company;
                }
            }
        }

        [Test]
        public void DeserializationTest()
        {
            Assert.AreEqual("meganalysis", Company.Name);
        }

        [Test]
        public void SerializationTest()
        {
            using (var fs = new FileStream(@"../../xsd/sampleCompanySerialized.xml", FileMode.Create))
            {
                var xs = new XmlSerializer(typeof(Company));
                xs.Serialize(fs, Company);
            }
        }

        [Test]
        public void TotalTest()
        {
            var total = Features.Total(Company);
            Assert.AreEqual(399747.0, total);
        }
    }
}
