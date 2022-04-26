import ApiConfig.Companion.baseUrl
import ApiConfig.Companion.browserAgent
import ApiConfig.Companion.headers
import io.gatling.javaapi.core.CoreDsl
import io.gatling.javaapi.http.HttpDsl

class SimulationConfig {

    companion object {
        val singleUser = CoreDsl.atOnceUsers(1)

        val httpProtocol = HttpDsl.http
            .baseUrl(baseUrl)
            .acceptHeader(headers)
            .userAgentHeader(browserAgent)
    }
}