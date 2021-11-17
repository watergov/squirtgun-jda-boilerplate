import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    application
}

group = "net.lucypoulton"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}

repositories.maven("https://m2.dv8tion.net/releases")

dependencies {
    implementation("net.lucypoulton:squirtgun-platform-discord:2.0.0-pre8")
}