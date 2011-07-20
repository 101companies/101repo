using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;

namespace linqToDataSets.Tests
{
    [TestFixture]
    public class FeaturesTests
    {
        [Test]
        public void TotalTest()
        {
            var total = Features.Total();
            Assert.AreEqual(399747M, total);

        }

        [Test]
        public void CutTest()
        {
            var totalBefore = Features.Total();
            Features.Cut();
            var totalAfter = Features.Total();

            Assert.AreEqual(totalBefore / 2, totalAfter);

        }
    }
}
