/**
 * Created by IntelliJ IDEA.
 * User: dackel
 * Date: 26.03.11
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */

import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val scalatest = "org.scalatest" %% "scalatest" % "1.4.1"
  val dispatch_json = "net.databinder" %% "dispatch-json"  % "0.8.1"
  val sjson = "net.debasishg" %% "sjson" % "0.12"
  //val squeryl = "org.squeryl" % "squeryl_2.8.1" % "0.9.4-RC6"
  val slf4s = "com.weiglewilczek.slf4s" %% "slf4s" % "1.0.6"
}