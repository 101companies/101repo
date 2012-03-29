name := "Scala Akka Actors"

version := "1.0"

organization := "org.softlang"

scalaVersion := "2.9.0-1"

scalacOptions ++= Seq("-deprecation", "-unchecked")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "se.scalablesolutions.akka" % "akka-actor" % "1.1.3",
  "se.scalablesolutions.akka" % "akka-typed-actor" % "1.1.3",
  "org.specs2" %% "specs2" % "1.4" % "test",
  "org.scalaz" %% "scalaz-core" % "6.0.1"
)
