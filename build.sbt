name := "CodingPractice"

scalaVersion := "2.9.2"

resolvers += "Twitter Repo" at "http://maven.twttr.com/"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.6.1"

libraryDependencies += "org.scala-tools.time" % "time_2.8.1" % "0.5"

libraryDependencies += "com.google.guava" % "guava" % "13.0"

libraryDependencies += "com.twitter" % "util-logging" % "5.3.10"

libraryDependencies += "commons-io" % "commons-io" % "2.1"

libraryDependencies += "com.jsuereth" %% "scala-arm" % "1.2"

libraryDependencies += "javax.transaction" % "jta" % "1.1" % "provided->default"

libraryDependencies += "org.apache.commons" % "commons-math" % "2.2"

libraryDependencies += "org.jsoup" % "jsoup" % "1.7.1"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.9.5"

libraryDependencies += "net.sf.opencsv" % "opencsv" % "2.0"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
 
libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"

libraryDependencies += "org.mongodb" %% "casbah" % "2.4.1"

libraryDependencies += "edu.stanford.nlp" % "stanford-corenlp" % "1.3.4"

libraryDependencies += "joda-time" % "joda-time" % "2.1"

libraryDependencies += "org.joda" % "joda-convert" % "1.2"

scalacOptions ++= Seq( "-deprecation", "-optimize" )



