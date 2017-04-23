ext.kotlin_version = "1.1.1"
ext.rest_assured_version = "2.9.0"

allprojects {
    group = "fables.kotlin.jee"
    version = "1.0"
}

subprojects {

    repositories {
        mavenLocal()
        mavenCentral()
    }

    plugins.withType(WarPlugin) {
        dependencies {
            providedCompile("javax:javaee-api:7.0")
        }
    }

    tasks.withType(JavaCompile) {
        options.encoding = "UTF-8"
    }
}
