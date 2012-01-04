using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;

namespace csharpXmlReader.Tests
{
    [TestFixture]
    public class FeaturesTests
    {
        [Test]
        public void TotalTest()
        {
            var total = Features.Total();
            Assert.AreEqual(total, 123456 + 12345 + 1234 + 234567 + 23456 + 2345 + 2344);
        }

        [Test]
        public void CutTest()
        {
            Features.Cut();
        }
    }
}
