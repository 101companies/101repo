package org.softlang.company.akkaactors

import akka.actor._
import akka.dispatch.Future

import Actor._

/**
 * Created by IntelliJ IDEA.
 * User: dackel
 * Date: 05.07.11
 * Time: 15:58
 * To change this template use File | Settings | File Templates.
 */

case object Cut

case object Total

class Company(val name: String, val depts: List[ActorRef]) extends Actor {

  def receive = {
    case Total => self reply {
      val totalDeptFutures: List[Future[Double]] = for {dept <- depts} yield {dept !!! Total}
      Future.sequence(totalDeptFutures).map(_.sum).get
    }
    case Cut => self reply {
      val cutDeptFutures: List[Future[ActorRef]] = for {dept <- depts} yield {dept !!! Cut}
      val cutDepts = Future.sequence(cutDeptFutures).get
      actorOf(new Company(name, cutDepts)).start()
    }
  }
}

class Dept(val name: String, val manager: ActorRef, val subUnits: List[ActorRef]) extends Actor {

  def receive = {
    case Total => self reply {
      val subTotals: List[Future[Double]] = for {sub <- (manager :: subUnits)} yield {sub !!! Total}
      Future.sequence(subTotals).map(_.sum).get
    }
    case Cut => self reply {
      val newSubsFuture: List[Future[ActorRef]] = for {sub <- subUnits} yield {sub !!! Cut}
      val newSubs = Future.sequence(newSubsFuture).get
      val newMan: ActorRef = (manager !!! Cut).get
      actorOf(new Dept(name, newMan, newSubs)).start()
    }
  }
}

class Employee(val name: String, val address: String, val salary: Double) extends Actor {
  def receive = {
    case Total => self reply salary
    case Cut => self reply  actorOf(new Employee(name, address, salary/2.0)).start()
  }
}

object Company {
  def apply(name: String, depts: List[ActorRef]) = actorOf(new Company(name, depts)).start()
}

object Dept {
  def apply(name: String, manager: ActorRef, subUnits: List[ActorRef]) =
    actorOf(new Dept(name, manager, subUnits)).start()
}

object Employee {
  def apply(name: String, address: String, salary: Double) = actorOf(new Employee(name, address, salary)).start()
}