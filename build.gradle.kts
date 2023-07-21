plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("org.jetbrains.intellij") version "1.15.0"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jsoup:jsoup:1.16.1")
    implementation("net.pearx.kasechange:kasechange-jvm:1.4.1")
    testImplementation("io.mockk:mockk:1.13.5")
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

intellij {
    version.set("2021.1")
    updateSinceUntilBuild.set(false)
}

sourceSets {
    main {
        java.srcDir("gen")
    }
}

tasks {
    publishPlugin {
        val publishPluginToken = project.properties["publishPluginToken"] as String
        token.set(publishPluginToken)
        channels.set(listOf("stable"))
    }
}
