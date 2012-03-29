package org.softlang.company.akkatypedactors

import org.specs2.mutable._

/**
 * Some tests for the TypedActor implementation
 */
class AkkaTypedActorCompanySpec extends Specification {
  def meganalysis = CompanyImpl(
    name = "meganalysis",
    depts = List(
      DeptImpl(
        name = "Research",
        manager = EmployeeImpl(
          name = "Craig",
          address = "Redmond",
          salary = 123456.0
        ),
        employees = List(
          EmployeeImpl(
            name = "Erik",
            address = "Utrecht",
            salary = 12345.0
          ),
          EmployeeImpl(
            name = "Ralf",
            address = "Koblenz",
            salary = 1234.0
          )
        ),
        subDepts = Nil
      ),
      DeptImpl(
        name = "Development",
        manager = EmployeeImpl(
          name = "Ray",
          address = "Redmond",
          salary = 234567.0
        ),
        subDepts = List(
          DeptImpl(
            name = "Dev1",
            manager = EmployeeImpl(
              name = "Klaus",
              address = "Boston",
              salary = 23456.0
            ),
            subDepts = List(
              DeptImpl(
                name = "Dev1.1",
                manager = EmployeeImpl(
                  name = "Karl",
                  address = "Riga",
                  salary = 2345.0
                ),
                subDepts = Nil,
                employees = List(
                  EmployeeImpl(
                    name = "Joe",
                    address = "Wifi City",
                    salary = 2344.0
                  )
                )
              )
            ),
            employees = Nil
          )
        ),
        employees = Nil
      )
    )
  )


  "A company" should {
    "correctly total the company's salaries" in {
      val company = meganalysis
      company.total mustEqual 399747.0
    }

    "correctly cut the company's salaries in half" in {
      val company = meganalysis
      val before = company.total
      company.cut()
      company.total mustEqual (before / 2.0)
    }

  }
}