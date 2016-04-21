name := "hello-world"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "spray repo" at "http://repo.spray.io"
resolvers += Resolver.sonatypeRepo("public")

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing-shapeless2" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV
  )
}

