package todo

import Scenario.Companion.createDeleteTodo
import SimulationConfig.Companion.httpProtocol
import SimulationConfig.Companion.singleUser
import io.gatling.javaapi.core.Simulation

class CreateTodoScenario  : Simulation() {
    init {
        setUp(createDeleteTodo.injectOpen(singleUser).protocols(httpProtocol))
    }
}