package org.softlang.company.scalaxml

import scala.xml._

/**
 * Created by IntelliJ IDEA.
 * User: dackel
 * Date: 03.07.11
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */

object CompanyXMLReader {

  def total(root: Elem) = (for {
    emp <- (root \\ "employee") ++ (root \\ "manager")
    salary <- emp \\ "salary"
  } yield salary.text.toDouble).sum

  def cut(root: Elem): Elem = {
    val name = NodeSeq.fromSeq(for {n <- root \ "name"} yield <name>{n.text}</name>)
    <company
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xmlns="http://www.softlang.org/company.xsd" >
      {name ++ (for {dept <- root \ "department"} yield cutDept(dept))}</company>
    }

  def cutDept(dept: Node): Node = {
    val subDepts = for {sd <- dept \ "department"} yield cutDept(sd)
    val employees = for {emp <- dept \ "employee"} yield cutEmployee(emp)
    val manager = for {man <- dept \ "manager"} yield cutEmployee(man)
    val name = NodeSeq.fromSeq (for {n <- dept \ "name"} yield <name>n.text</name>)

    <department>
      {name ++ manager ++ employees ++ subDepts}
    </department>

  }

  def cutEmployee(employee: Node): Node = {
    val newSalary = for {salary <- employee \ "salary"} yield <salary>{salary.text.toDouble / 2.0}</salary>

    val name = for {n <- employee \ "name"} yield <name>{n.text}</name>
    val address = for {addr <- employee \ "address"} yield <address>{addr.text}</address>

    employee match {
      case <employee>{_*}</employee> => <employee>{name ++ address ++ newSalary}</employee>
      case <manager>{_*}</manager> => <manager>{name ++ address ++ newSalary}</manager>
      case _ => throw new RuntimeException("Malformed employee tag: " + employee.toString)
    }
  }


}