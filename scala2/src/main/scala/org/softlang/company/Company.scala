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

  def cut(c: Company): Company = Company(c.name, c.depts.map(Company.cut(_)))

  def cut(e: Employee): Employee = Employee(e.name, e.salary/2.0)

  def cut(s: SubUnit): SubUnit = s match {
    case d: Dept => Company.cut(d)
    case e: Employee => Company.cut(e)
  }

  def cut(d: Dept): Dept = {
    Dept(d.name, Company.cut(d.manager), d.subUnits.map(Company.cut(_)))
  }
}