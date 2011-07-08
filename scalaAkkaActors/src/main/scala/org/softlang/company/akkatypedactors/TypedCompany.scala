package org.softlang.company.akkatypedactors

import akka.actor.TypedActor

/**
 * Created by IntelliJ IDEA.
 * User: dackel
 * Date: 05.07.11
 * Time: 09:45
 * To change this template use File | Settings | File Templates.
 */


trait Company {
  def total: Double
  def cut()
}

trait Dept {
  def total: Double
  def cut()
}

trait Employee {
  def total: Double
  def cut()
}

class CompanyImpl(val name: String, val depts: List[Dept]) extends TypedActor with Company {

  def total: Double = depts.foldLeft(0.0) {
    _ + _.total
  }

  def cut() {
    depts foreach {
      _.cut()
    }
  }
}


class DeptImpl(val name: String, val manager: Employee,
               val subDepts: List[Dept], val employees: List[Employee]) extends TypedActor with Dept {

  def total = {
    (subDepts.foldLeft(0.0) {
      _ + _.total
    }) + (employees.foldLeft(0.0) {
      _ + _.total
    }) + manager.total
  }

  def cut() {
    subDepts foreach {
      _.cut
    }
    employees foreach {
      _.cut
    }
    manager.cut()
  }
}

class EmployeeImpl(val name: String, val address: String, var salary: Double) extends TypedActor with Employee {

  def total = salary

  def cut() {
    salary /= 2.0
  }
}

object CompanyImpl {
  def apply(name: String, depts: List[Dept]): Company = TypedActor.newInstance(classOf[Company], new CompanyImpl(name, depts))
}

object DeptImpl {

  def apply(name: String, manager: Employee, subDepts: List[Dept], employees: List[Employee]): Dept =
    TypedActor.newInstance(classOf[Dept], new DeptImpl(name, manager, subDepts, employees))
}

object EmployeeImpl {
  def apply(name: String, address: String, salary: Double): Employee =
    TypedActor.newInstance(classOf[Employee], new EmployeeImpl(name, address, salary))
}