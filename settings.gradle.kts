pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
    }
}
rootProject.name = "mvu-presentation"

enableFeaturePreview("GRADLE_METADATA")

include(":presentation")

