rootProject.name = "Elyx-Services"


dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven(url = "https://repo.openrs2.org/repository/openrs2-snapshots/")
    }
    pluginManagement.plugins.apply {
        kotlin("jvm").version("1.9.10")
    }
}

include("Application")
include("Js5")