import ApiConfig.Companion.applicationJson
import ApiConfig.Companion.baseUrl
import ApiConfig.Companion.browserAgent
import io.gatling.javaapi.core.CoreDsl
import io.gatling.javaapi.http.HttpDsl

class SimulationConfig {

    companion object {
        val singleUser = CoreDsl.atOnceUsers(1)

        val httpProtocol = HttpDsl.http
            .baseUrl(baseUrl)
            .acceptHeader(applicationJson)
            .contentTypeHeader(applicationJson)
            .userAgentHeader(browserAgent)
    }
}