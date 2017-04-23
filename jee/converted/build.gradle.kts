import org.gradle.script.lang.kotlin.compile
import org.gradle.script.lang.kotlin.dependencies
import org.gradle.script.lang.kotlin.extra

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.1.1")
}

apply {
    plugin("kotlin")
    plugin("war")
}

description = "Kotlin Server without Plugins"

dependencies {
    compile("com.fasterxml.jackson.core:jackson-annotations:${extra["jackson_version"]}")
    compile("org.jetbrains.kotlin:kotlin-stdlib:${extra["kotlin_version"]}") // needed for ::class.java
}