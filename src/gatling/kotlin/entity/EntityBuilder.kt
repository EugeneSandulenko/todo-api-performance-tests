package entity

class EntityBuilder {

    companion object {
        const val newTodo = """{
                "id": 0,
                "title": "uncompleted task",
                "completed": false,
                "order": 1
            }""";

        const val patchTodo = """{
                "id": 0,
                "title": "Completed task",
                "completed": true,
                "order": 2
            }""";
    }
}