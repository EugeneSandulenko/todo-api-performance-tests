package todo

import Scenario.Companion.createDeleteTodo
import SimulationConfig.Companion.httpProtocol
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation
import java.time.Duration.*

class MultiUserScenario: Simulation() {
    init {
        setUp(
            createDeleteTodo.injectOpen(
               nothingFor(ofMinutes(1)),
               constantUsersPerSec(100.0).during(ofMinutes(1)),
               rampUsersPerSec(1.0).to(5.0).during(ofSeconds(30))
            ).protocols(httpProtocol.inferHtmlResources())
        )
    }
}