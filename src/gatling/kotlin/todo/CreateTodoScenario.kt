package todo

import Scenario.Companion.createTodo
import SimulationConfig.Companion.httpProtocol
import SimulationConfig.Companion.singleUser
import io.gatling.javaapi.core.Simulation

class CreateTodoScenario  : Simulation() {
    init {
        setUp(createTodo.injectOpen(singleUser).protocols(httpProtocol))
    }
}