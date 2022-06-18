plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
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
