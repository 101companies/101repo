using System.Collections.Generic;
using csharpBaseline.CompanyModel;
using NUnit.Framework;

namespace csharpBaseline.Tests
{
    [TestFixture]
    public class SerializationTests
    {
        private static Company Company
        {
            get
            {
                return CompanyBuilder.CreateInMemoryModel();
            }
        }

        [Test]
        public void EqualsTest()
        {
            var c1 = Company;
            var c2 = Company;
            Assert.AreEqual(true, c1.Equals(c2));
        }

        [Test] 
        public void SerializationTest()
        {
            var c = Company;
            var xmlizedString = SerializationHelper.SerializeObject(c, typeof(Company));
            var reconstructedCompany = SerializationHelper.DeserializeObject<Company>(xmlizedString);
          
            Assert.AreEqual(true, c.Equals(reconstructedCompany));
        }

    }
}
