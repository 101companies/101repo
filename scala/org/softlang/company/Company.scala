package org.softlang.company

/**
 * A company has a name and top departments.
 */
class Company {
  private var name: String = ""
  private var depts: List[Dept] = List()

  def getName = name
  def setName(name: String) = {
    this.name = name
  }

  def getDepts = depts
  def setDepts(depts: List[Dept]) = {
    this.depts = depts
  }

  def total: Double = getDepts.map(_.total).reduceLeft[Double](_ + _)

  def cut: Unit = {
    getDepts.foreach(_.cut)
  }

}