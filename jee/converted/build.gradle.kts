import org.gradle.api.tasks.bundling.War

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.1.2"
}

apply {
    plugin("kotlin")
    plugin("war")
}

(tasks["war"] as War).archiveName = "converted.war"

/*tasks {
    "war"(War::class) {
        archiveName = "converted.war"
    }
}*/

description = "Kotlin Server without Plugins"

dependencies {
    compile("com.fasterxml.jackson.core:jackson-annotations:${extra["jackson_version"]}")
    compile("org.jetbrains.kotlin:kotlin-stdlib:${extra["kotlin_version"]}") // needed for ::class.java
}
