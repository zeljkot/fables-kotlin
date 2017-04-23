plugins {
    id("org.jetbrains.kotlin.jvm").version("1.1.1")
    id("org.jetbrains.kotlin.plugin.allopen").version("1.1.1")
    //id( "org.jetbrains.kotlin.plugin.jpa" ) version ( "1.1.1")
    id("org.jetbrains.kotlin.plugin.noarg").version("1.1.1")
}

apply {
    plugin("kotlin")
    plugin("kotlin-allopen")
    plugin("kotlin-jpa")
    plugin("kotlin-noarg")
    plugin("war")
}

description = "Kotlin Server with All Plugins"

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.ejb.Stateless")
}

noArg {
    annotation("javax.ws.rs.Path")
    annotation("javax.ejb.Stateless")
}

dependencies {
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:${extra["jackson_version"]}")

    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:${extra["kotlin_version"]}")
    compile("org.jetbrains.kotlin:kotlin-reflect:${extra["kotlin_version"]}")
}
