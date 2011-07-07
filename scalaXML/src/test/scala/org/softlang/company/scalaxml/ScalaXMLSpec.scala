package org.softlang.company.scalaxml

import org.specs2.mutable.Specification
import scala.xml._

import org.specs2.mutable._

/**
 * Created by IntelliJ IDEA.
 * User: dackel
 * Date: 06.07.11
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */

class ScalaXMLSpec extends Specification {

  "A CompanyXMLReader" should {
    "correctly load and total a valid Company XML file" in {
      CompanyXMLReader.total(XML.load("./sampleCompany.xml")) mustEqual 399747.0
    }

    "correctly load and cut a valid Company XML file" in {
      val original = XML.load("./sampleCompany.xml")
      val cutXML = CompanyXMLReader.cut(original)
      CompanyXMLReader.total(cutXML) mustEqual (CompanyXMLReader.total(original) / 2.0)
    }

    "save valid XML files" in {
      val original = XML.load("./sampleCompany.xml")
      val cutXML = CompanyXMLReader.cut(original)
      XML.save("./cutResult.xml", cutXML)
      Validator.validate("./cutResult.xml", "./Company.xsd") must beTrue
    }
  }
}