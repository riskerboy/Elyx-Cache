import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to "com.cryptic.UpdateCacheKt")
    }
}

allprojects {
    apply(plugin = "kotlin")

    group = "com.cryptic"
    version = "1.0"

    repositories {
        mavenCentral()
        maven(url = "https://repo.runelite.net/")
        maven(url = "https://repo.openrs2.org/repository/openrs2-snapshots/")
        maven(url = "https://jitpack.io")
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("io.github.microutils:kotlin-logging:3.0.5")
        val slf4jVersion = "2.0.9"
        implementation("org.slf4j:slf4j-api:$slf4jVersion")
        runtimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")
        implementation("me.tongfei:progressbar:0.9.2")
        implementation("com.displee:rs-cache-library:7.1.3")


    }

    kotlin {
        jvmToolchain(17)
    }

}
val applicationModule = project(":Application")


tasks {

    register<JavaExec>("Run JS5") {
        group = "Service"
        description = "Runs the Js5 Server"
        classpath = applicationModule.sourceSets.main.get().runtimeClasspath
        mainClass.set("com.elyx.RunJs5Kt")
        jvmArgs = listOf(
            "-XX:-OmitStackTraceInFastThrow",
            "-Xmx8g",
            "-Xms4g",
            "-XX:+UseZGC",
            "-XX:MaxGCPauseMillis=100",
            "-Dio.netty.tryReflectionSetAccessible=true",
        )
    }

    register<JavaExec>("Update Rev") {
        group = "Service"
        description = "Update Cache to the defined revision"
        classpath = applicationModule.sourceSets.main.get().runtimeClasspath
        mainClass.set("com.elyx.UpdateCacheKt")
    }

    register<JavaExec>("Build Cache") {
        group = "Service"
        description = "Pack all custom Files into the cache"
        classpath = applicationModule.sourceSets.main.get().runtimeClasspath
        mainClass.set("com.elyx.BuildCacheKt")
    }

}

