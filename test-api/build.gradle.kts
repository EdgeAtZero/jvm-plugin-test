plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("io.ktor:ktor-client-core:2.0.2")

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
