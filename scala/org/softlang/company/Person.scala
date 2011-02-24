package org.softlang.company

/**
 * A person has a name and an address.
 */
class Person {
  private var name: String = ""
  private var address: String = ""

  def getName = name
  def setName(name: String) = {
    this.name = name
  }

  def getAddress = address
  def setAddress(address: String) = {
    this.address = address
  }

}