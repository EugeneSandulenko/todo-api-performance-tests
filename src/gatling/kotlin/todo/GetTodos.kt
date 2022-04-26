package todo

import ApiConfig.Companion.todosUrl
import SimulationConfig.Companion.httpProtocol
import SimulationConfig.Companion.singleUser
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.*

class GetTodos : Simulation() {

    private val scn = scenario("Get all todos")
        .exec(http("getToDos").get(todosUrl))

    init {
        setUp(scn.injectOpen(singleUser).protocols(httpProtocol))
    }
}