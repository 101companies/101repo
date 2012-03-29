/**
 * Created by IntelliJ IDEA.
 * User: dackel
 * Date: 28.03.11
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */

import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val scalatest = "org.scalatest" % "scalatest" % "1.3"
}