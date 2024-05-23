plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junit5Version = "5.10.2"

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
//    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junit5Version}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${junit5Version}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junit5Version}")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}