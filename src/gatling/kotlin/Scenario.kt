import ApiConfig.Companion.baseUrl
import ApiConfig.Companion.todosUrl
import entity.EntityBuilder.Companion.newTodo
import entity.EntityBuilder.Companion.patchTodo
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*

class Scenario {

    companion object {

        val getAllTodos = scenario("Get all todos")
            .exec(http("getToDos").get(todosUrl))

        val createDeleteTodo = scenario("Create todo")
            .exec(
                http("create todo")
                    .post(todosUrl)
                    .body(StringBody(newTodo)).asJson()
                    .check(status().`is`(200))
                    .check(jsonPath("$.id").saveAs("TodoId"))
            )
            .pause(1)
            .exec(
                http("get created todo")
                    .get("#{baseUrl}#{todosUrl}/#{TodoId}")
                    .check(status().`is`(200))
                    .check(jsonPath("$.id").saveAs("TodoId"))

            )
            .pause(3)
            .exec(
                http("patch created todo")
                    .patch("#{baseUrl}#{todosUrl}/#{TodoId}")
                    .body(StringBody(patchTodo)).asJson()
                    .check(status().`is`(200))
            )
            .exec(
                http("get all todos")
                    .get("#{baseUrl}#{todosUrl}")
                    .check(status().`is`(200))
            )
            .exec(
                http("delete todo")
                    .delete("#{baseUrl}#{todosUrl}/#{TodoId}")
                    .check(status().`is`(204))
            )
    }
}

