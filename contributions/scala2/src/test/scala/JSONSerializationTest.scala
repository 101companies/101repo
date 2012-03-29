
import org.softlang.company._
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import sjson.json._
import JSONProtocols._
import JsonSerialization._

/**
 * Tests for JSON serialization
 */

class JSONSerializationTest extends Spec with ShouldMatchers {

    val company = Company(
    name = "meganalysis",
    depts = List(
      Dept(
        name = "Research",
        manager = Employee(
          name = "Craig",
          salary = 123456.0
        ),
        subUnits = List(
          Employee(
            name = "Erik",
            salary = 12345.0
          ),
          Employee(
            name = "Ralf",
            salary = 1234.0
          )
        )
      ),
      Dept(
        name = "Development",
        manager = Employee(
          name = "Ray",
          salary = 234567.0
        ),
        subUnits = List(
          Dept(
            name = "Dev1",
            manager = Employee(
              name = "Klaus",
              salary = 23456.0
            ),
            subUnits = List(
              Dept(
                name = "Dev1.1",
                manager = Employee(
                  name = "Karl",
                  salary = 2345.0
                ),
                subUnits = List(
                  Employee(
                    name = "Joe",
                    salary = 2344.0
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  describe("Meganalysis Ltd.") {
    it("should properly serialize to JSON") {
      val serialCompany = fromjson[Company](tojson(company))
      serialCompany should equal(company)
    }

  }
}