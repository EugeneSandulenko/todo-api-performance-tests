package todo

import io.gatling.javaapi.core.CoreDsl
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl

class GetTodos : Simulation() {

    private val httpProtocol = HttpDsl.http
        .baseUrl("https://localhost:7138/api/") // Here is the API root URL
        .acceptHeader("application/json")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

    private val scn = CoreDsl.scenario("Get all todos") // A scenario is a chain of requests and pauses
        .exec(HttpDsl.http("getToDos").get("/todos"))

    init {
        setUp(scn.injectOpen(CoreDsl.atOnceUsers(1)).protocols(httpProtocol))
    }
}