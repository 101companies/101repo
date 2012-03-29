package org.softlang.company

import sjson.json._
import sjson.json.CollectionTypes

/**
 * Created by Sebastian Jackel for the 101Companies project under Prof. Ralf Lämmel
 * Typeclass based JSON serialization, currently still ugly.
 */

object JSONProtocols extends DefaultProtocol {

  import dispatch.json._

  implicit object SubUnitFormat extends Format[SubUnit] {

    import JSONProtocols._
    import JsonSerialization._

    def reads(json: JsValue): SubUnit = json match {
      case j@JsObject(m) => m.get(JsString("salary")) match {
        case Some(x) => fromjson[Employee](j)
        case None => fromjson[Dept](j)
      }
      case _ => throw new RuntimeException("Not a valid JSON value")
    }

    def writes(s: SubUnit): JsValue = s match {
      case d: Dept => tojson(d)
      case e: Employee => tojson(e)
    }

  }

  implicit val EmployeeFormat: Format[Employee] = lazyFormat(asProduct2("name", "salary")(Employee.apply)(Employee.unapply(_).get))
  implicit val DeptFormat: Format[Dept] = lazyFormat(asProduct3("dept", "manager", "subUnits")(Dept.apply)(Dept.unapply(_).get))
  implicit val CompanyFormat: Format[Company] = lazyFormat(asProduct2("company", "depts")(Company.apply)(Company.unapply(_).get))
}