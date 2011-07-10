package org.softlang.company.akkaactors

import org.specs2.mutable._
import akka.actor.ActorRef

/**
 * Some tests for the untyped actor spec
 */

class AkkaActorSpec extends Specification {

  val meganalysis = Company(
    name = "meganalysis",
    depts = List(
      Dept(
        name = "Research",
        manager = Employee(
          name = "Craig",
          address = "Redmond",
          salary = 123456.0
        ),
        subUnits = List(
          Employee(
            name = "Erik",
            address = "Utrecht",
            salary = 12345.0
          ),
          Employee(
            name = "Ralf",
            address = "Koblenz",
            salary = 1234.0
          )
        )
      ),
      Dept(
        name = "Development",
        manager = Employee(
          name = "Ray",
          address = "Redmond",
          salary = 234567.0
        ),
        subUnits = List(
          Dept(
            name = "Dev1",
            manager = Employee(
              name = "Klaus",
              address = "Boston",
              salary = 23456.0
            ),
            subUnits = List(
              Dept(
                name = "Dev1.1",
                manager = Employee(
                  name = "Karl",
                  address = "Riga",
                  salary = 2345.0
                ),
                subUnits = List(
                  Employee(
                    name = "Joe",
                    address = "Wifi City",
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

  "A company" should {
    "correctly total the company's salaries" in {
      (meganalysis !!! Total).get.asInstanceOf[Double] mustEqual 399747.0
    }

    "correctly cut the company's salaries in half" in {
      val before: Double = (meganalysis !!! Total).get
      val company: ActorRef = (meganalysis !!! Cut).get
      (company !!! Total).get.asInstanceOf[Double] mustEqual (before / 2.0)
    }
  }
}