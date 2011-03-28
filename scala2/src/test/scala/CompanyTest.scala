/**
 * Small test for consistency in the Company datastructure
 */

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers
import org.softlang.company._

class CompanyTest extends WordSpec with ShouldMatchers {

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

  "Meganalysis Ltd." should {
    "not have an empty name" in {
      company.name should not have length(0)
    }

    "pay it's employees a monthly salary of 399747" in {
      Company.total(company) should equal(399747.0)
    }

    "reduce company total pay by half in case of a cut" in {
      val cutCompany = Company.cut(company)
      Company.total(cutCompany) should equal(Company.total(company)/2.0)
    }
  }

  "All of Meganalysis Ltd.'s departments" should {
    "not have an empty name" in {
      def getDepts(s: SubUnit): List[Dept] = s match {
        case d@Dept(_, _, subs) => d :: (subs.flatMap(getDepts))
        case _ => Nil
      }
      val depts: List[Dept] = company.depts ::: company.depts.flatMap(getDepts)

      depts.map(_.name) should not contain("")
    }

  }
}