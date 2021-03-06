package todo

import Scenario.Companion.getAllTodos
import SimulationConfig.Companion.httpProtocol
import SimulationConfig.Companion.singleUser
import io.gatling.javaapi.core.Simulation

class GetTodos : Simulation() {

    init {
        setUp(getAllTodos.injectOpen(singleUser).protocols(httpProtocol))
    }
}