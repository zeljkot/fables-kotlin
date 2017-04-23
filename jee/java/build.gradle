apply {
    plugin( "war")
}

description = "Java Reference Server"

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile ("com.fasterxml.jackson.core:jackson-annotations:$jackson_version")

    testCompile("com.fasterxml.jackson.core:jackson-core:${extra["jackson_version"]}")
    testCompile (group: "com.jayway.restassured", name: "rest-assured", version: rest_assured_version)
    testCompile (group: "junit", name: "junit", version: "4.12")
    testCompile (group: "org.hamcrest", name: "hamcrest-all", version: "1.3")
}