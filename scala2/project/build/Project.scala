/**
 * Created by IntelliJ IDEA.
 * User: dackel
 * Date: 26.03.11
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */

import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val scalatest = "org.scalatest" % "scalatest" % "1.3"
  val dispatch_json = "net.databinder" % "dispatch-json_2.8.1"  % "0.7.8"
  val sjson = "net.debasishg" % "sjson_2.8.1" % "0.10"
  val casbah = "com.mongodb.casbah" % "casbah_2.8.1" % "2.1.0"
}