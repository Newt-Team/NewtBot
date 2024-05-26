plugins {
    java
    kotlin("jvm") version "2.0.0"
    application
}

application.mainClass.set("inteleonyx.newt.NewtBot")
group = "inteleonyx.newt"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    //Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0-RC")
    //JDA
    implementation("net.dv8tion:JDA:5.0.0-beta.24")
    implementation("club.minnced:jda-ktx:0.11.0-beta.20")
    //Google
    implementation ("com.google.code.gson:gson:2.11.0")
    //Apache
    implementation("org.apache.commons:commons-configuration2:2.10.1")
    //Dotenv
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
    //Requests
    implementation("com.squareup.okhttp3:okhttp:4.9.2")
    //Ktor
    implementation("io.ktor:ktor-client-core:2.3.11")
    implementation("io.ktor:ktor-client-json:2.3.11")
    implementation("io.ktor:ktor-client-okhttp:2.3.11")
}

