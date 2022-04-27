Gatling plugin for Gradle - Kotlin ToDo API demo project
===============================================

A simple showcase of a Gradle project using the Gatling plugin for Gradle. Refer to the plugin documentation
[on the Gatling website](https://gatling.io/docs/current/extensions/gradle_plugin/) for usage.

It includes:

* Gradle Wrapper, so you don't need to install Gradle (a JDK must be installed and $JAVA_HOME configured)
* minimal `build.gradle` leveraging Gradle wrapper
* latest version of `io.gatling.gradle` plugin applied
* sample [Simulation](https://gatling.io/docs/gatling/reference/current/general/concepts/#simulation) class,
demonstrating sufficient Gatling functionality
* proper source file layout

Template to run tests:
```
./gradlew gatlingRun-<test_class_name>
```

Examples. 
1. Run GetTodos test class:
```
./gradlew gatlingRun-todo.GetTodos
```

2. Run MultiUserScenario:

```
./gradlew gatlingRun-todo.MultiUserScenario
```