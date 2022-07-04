package eu.esnup.gestioncomptetest.scala

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Gatling extends Simulation {

  val scn = scenario("Home Page")
    .during(1 minute){
      exec(http("Home Page")
        .get("http://google.fr"))
        .pause(5,10)
    }
  setUp(scn.inject(rampUsers(10) during(1 minutes)))
}