name := "Akka simple server"

version := "0.1"

scalaVersion := "2.10.3"

resolvers ++= Seq (
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Spray repository" at "http://repo.spray.io"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.10" % "2.3.0",
  "org.mashupbots.socko" % "socko-rest_2.10" % "0.3.1"
)
