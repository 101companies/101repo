package org.softlang.company

/**
 * A subunit is either a person unit or a sub department.
 */
class Subunit {
  private var pu: Employee = null
  private var du: Dept = null

  def this(pu: Employee) = {
    this()
    this.pu = pu
  }
  def this(du: Dept) = {
    this()
    this.du = du
  }

  def getPu = pu
  def setPu(pu: Employee) = {
    this.pu = pu
    this.du = null
  }

  def getDu = du
  def setDu(du: Dept) = {
    this.pu = null
    this.du = du
  }

  def total: Double = if (getPu != null) getPu.total else if (getDu != null) getDu.total else 0.0

  def cut: Unit = {
    if (getPu != null)
      getPu.cut
    if (getDu != null)
      getDu.cut

  }
}