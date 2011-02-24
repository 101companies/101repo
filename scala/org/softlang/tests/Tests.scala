package org.softlang.tests

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.softlang.company._

class Tests extends AssertionsForJUnit {

  var sampleCompany: Company = _

  @Before
  def initialize() {

    sampleCompany = new Company()
    sampleCompany.setName("meganalysis")

    var craig = new Person()
    craig.setName("Craig")
    craig.setAddress("Redmond")
    var erik = new Person()
    erik.setName("Erik")
    erik.setAddress("Utrecht")
    var ralf = new Person()
    ralf.setName("Ralf")
    ralf.setAddress("Koblenz")
    var ray = new Person()
    ray.setName("Ray")
    ray.setAddress("Redmond")
    var klaus = new Person()
    klaus.setName("Klaus")
    klaus.setAddress("Boston")
    var karl = new Person()
    karl.setName("Karl")
    karl.setAddress("Riga")
    var joe = new Person()
    joe.setName("Joe")
    joe.setAddress("Wifi City")

    var CraigE = new Employee()
    var erikE = new Employee()
    var ralfE = new Employee()
    var rayE = new Employee()
    var klausE = new Employee()
    var karlE = new Employee()
    var joeE = new Employee()

    CraigE.setPerson(craig)
    erikE.setPerson(erik)
    ralfE.setPerson(ralf)
    rayE.setPerson(ray)
    klausE.setPerson(klaus)
    karlE.setPerson(karl)
    joeE.setPerson(joe)

    CraigE.setSalary(123456)
    erikE.setSalary(12345)
    ralfE.setSalary(1234)
    rayE.setSalary(234567)
    klausE.setSalary(23456)
    karlE.setSalary(2345)
    joeE.setSalary(2344)

    var research = new Dept()
    var researchS1 = new Subunit()
    var researchS2 = new Subunit()

    research.setManager(CraigE)
    research.setName("Research")
    researchS1.setPu(erikE)
    researchS2.setPu(ralfE)
    research.setSubunits(research.getSubunits ::: List(researchS1))
    research.setSubunits(research.getSubunits ::: List(researchS2))

    var development = new Dept()
    development.setManager(rayE)
    development.setName("Development")
    var developmentS1 = new Subunit()
    development.setSubunits(development.getSubunits ::: List(developmentS1))
    var dev1 = new Dept()
    dev1.setName("Dev1")
    dev1.setManager(klausE)
    developmentS1.setDu(dev1)
    var dev1S1 = new Subunit()
    dev1.setSubunits(dev1.getSubunits ::: List(dev1S1))
    var dev11 = new Dept()
    dev11.setName("Dev1.1")
    dev11.setManager(karlE)
    dev1S1.setDu(dev11)
    var dev11S1 = new Subunit
    dev11S1.setPu(joeE)
    dev11.setSubunits(dev11.getSubunits ::: List(dev11S1))
    sampleCompany.setDepts((sampleCompany.getDepts ::: List(research)) ::: List(development))
  }

  @Test
  def testTotal() {
    assertEquals(399747, sampleCompany.total, 0.0)
  }

  @Test
  def testCut() {
    var preCutTotal = sampleCompany.total
    sampleCompany.cut
    var newTotal = sampleCompany.total
    assertEquals(preCutTotal / 2, newTotal, 0.0)
  }
}