rootProject.name = "Elyx-Services"


dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
    pluginManagement.plugins.apply {
        kotlin("jvm").version("1.9.10")
    }
}

include("Application")
