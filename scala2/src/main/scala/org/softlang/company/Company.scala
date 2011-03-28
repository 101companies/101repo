package org.softlang.company

/**
 * Created by Sebastian Jackel for 101Companies by Ralf Lämmel
 * Idiomatic Scala implementation of the 101Companies basics
 */

trait SubUnit

case class Company(name: String, depts: List[Dept])

case class Dept(name: String, manager: Employee, subUnits: List[SubUnit]) extends SubUnit

case class Employee(name: String, salary: Double) extends SubUnit


object Company {
  def total(company: Company) = {
    def subTotal(s: SubUnit): Double = s match {
      case d: Dept => (for (su <- d.subUnits) yield subTotal(su)).reduceLeft(_ + _) + subTotal(d.manager)
      case e: Employee => e.salary
    }

    company.depts.map(subTotal).reduceLeft(_ + _)
  }

  def cut(company: Company): Company = {
    trait CutFactory[T] {
      def apply(t: T): T
    }


    implicit object SubUnitCutFactory extends CutFactory[SubUnit] {
      override def apply(s: SubUnit) = s match {
        case d: Dept => DeptCutFactory(d)
        case e: Employee => EmployeeCutFactory(e)
      }
    }

    implicit object EmployeeCutFactory extends CutFactory[Employee] {
      override def apply(e: Employee) = Employee(e.name, e.salary / 2.0)
    }
    implicit object DeptCutFactory extends CutFactory[Dept] {
      override def apply(d: Dept) = Dept(d.name, subCut(d.manager), d.subUnits.map(subCut(_)))
    }


    def subCut[T <: SubUnit](s: T)(implicit factory: CutFactory[T]): T = factory(s)

    Company(company.name, company.depts.map(subCut(_)))

  }
}