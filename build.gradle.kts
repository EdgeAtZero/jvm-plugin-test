plugins {
    kotlin("jvm") version "1.7.0"
    kotlin("plugin.serialization") version "1.7.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":test-api"))
    implementation(project(":test-dependence"))

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    implementation("io.ktor:ktor-client-core:2.0.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")

    testImplementation(kotlin("test"))
}

tasks {
    kotlin {
        compileKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    test {
        useJUnitPlatform()
    }
}

application {
    mainClass.set("MainKt")
}