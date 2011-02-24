package org.softlang.company

/**
 * An Employee has some person information and receives a salary.
 */
class Employee {
  private var person: Person = _
  private var salary: Double = 0.0

  def getPerson = person
  def setPerson(person: Person) = {
    this.person = person
  }

  def getSalary = salary
  def setSalary(salary: Double) = {
    this.salary = salary
  }

  def total: Double = getSalary

  def cut: Unit = {
    setSalary(getSalary / 2)
  }

}