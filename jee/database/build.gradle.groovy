plugins {
    id("org.flywaydb.flyway").version("4.1.2")
}

apply {
    plugin("java")
}

description = "Animal test database"

flyway {
    url = "jdbc:postgresql://localhost:5432/test"
    user = "postgres"
    password = "postgres"
}

dependencies {
    runtimeOnly("org.postgresql:postgresql:42.0.0")
}
