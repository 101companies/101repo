package org.softlang.company

/**
 * A department has a name, a manager and subunits.
 */
class Dept {
  private var name: String = ""
  private var manager: Employee = _
  private var subunits: List[Subunit] = List()

  def getName = name
  def setName(name: String) = {
    this.name = name
  }

  def getManager = manager
  def setManager(manager: Employee) = {
    this.manager = manager
  }

  def getSubunits = subunits
  def setSubunits(subunits: List[Subunit]) = {
    this.subunits = subunits
  }

  def total: Double = getManager.total +
    (if (!subunits.isEmpty) (getSubunits.map(_.total).reduceLeft[Double](_ + _)) else 0)

  def cut: Unit = {
    getManager.cut
    getSubunits.foreach(_.cut)
  }

}