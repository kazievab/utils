resolvers in ThisBuild += "Artima Maven Repository" at "https://repo.artima.com/releases"

addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.12")

addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.16")

addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.25")

addSbtPlugin("com.geirsson" % "sbt-ci-release" % "1.5.5")