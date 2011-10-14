using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Xml;
using NUnit.Framework;
using csharpBaseline;

namespace xsdComposition.Tests
{
    [TestFixture]
    public class FeaturesTests
    {
        private Company Company
        {
            get
            {
                string xmlizedString;
                using (var fs = new FileStream(@"../../xsd/sampleCompany.xml", FileMode.Open))
                {
                    using (var tr = new StreamReader(fs))
                    {
                        xmlizedString = tr.ReadToEnd();
                    }
                }

                var reconstructedCompany = SerializationHelper.DeserializeObject<Company>(xmlizedString);
                return reconstructedCompany;
            }
        }

        [Test]
        public void DeserializationTest()
        {
            Assert.AreEqual("meganalysis", Company.Name);
        }

        [Test]
        public void TotalTest()
        {
            var total = Company.Total;
            Assert.AreEqual(399747.0, total);
        }
    }
}
