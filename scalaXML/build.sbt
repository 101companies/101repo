name := "Scala Companies XML"

version := "1.0"

organization := "org.softlang"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.4" % "test",
  "org.scalaz" %% "scalaz-core" % "6.0.1"
)

scalacOptions += "-deprecation"

scalaVersion := "2.9.0-1"
