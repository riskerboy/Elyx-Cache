plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    maven("https://raw.githubusercontent.com/riskerboy/hosting/master")
}

dependencies {
    implementation("dev.openrune:filestore:1.2.6")
    implementation("dev.openrune:js5server:1.0.3")
    
    val slf4jVersion = "2.0.12"
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    runtimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")
    // https://mvnrepository.com/artifact/com.github.depsypher/pngtastic
    implementation("com.github.depsypher:pngtastic:1.7")

}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to "com.cryptic.UpdateCacheKt")
    }
}
