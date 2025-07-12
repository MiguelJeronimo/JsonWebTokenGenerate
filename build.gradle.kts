plugins {
    kotlin("jvm") version "2.1.20"
}

group = "org.mike"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

//jar generate
tasks.register<Jar>("JsonWebToken") {
    archiveClassifier.set("all")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get()
            .filter { it.name.endsWith("jar") }
            .map { zipTree(it) }
    })

    manifest {
        attributes["Main-Class"] = "org.mike.MainKt" // o la clase con main
    }
}
tasks.build {
    dependsOn("JsonWebToken")
}
dependencies {
    implementation("com.auth0:java-jwt:4.4.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}