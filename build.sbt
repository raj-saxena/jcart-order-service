name := "jcart-order-service"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.10"
  , "com.typesafe.akka" %% "akka-http-testkit" % "10.0.10"

  , "org.scalactic" %% "scalactic" % "3.0.1"
  , "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

logBuffered in Test := false