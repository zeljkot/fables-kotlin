import org.gradle.api.tasks.compile.JavaCompile

allprojects {
    group = "fables.kotlin.jee"
    version = "1.0"

    repositories {
        gradleScriptKotlin()
    }

}

subprojects {

    repositories {
        mavenLocal()
        mavenCentral()
    }

    plugins.withType(WarPlugin::class.java) {
        dependencies {
            compileOnly("javax:javaee-api:7.0")
        }
    }

    tasks.withType(JavaCompile::class.java) {
        options.encoding = "UTF-8"
    }
}
