import ApiConfig.Companion.todosUrl
import entity.EntityBuilder
import entity.EntityBuilder.Companion.newTodo
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import javax.swing.text.html.parser.Entity


class Scenario {

    companion object {

        val getAllTodos = scenario("Get all todos")
            .exec(http("getToDos").get(todosUrl))

        val createTodo = scenario("Create todo")
            .exec(
                http("create todo")
                    .post(todosUrl)
                    .body(StringBody(newTodo)).asJson()
                    .check(status().`is`(200))
            )
    }
}

