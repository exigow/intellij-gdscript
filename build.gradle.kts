plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    id("org.jetbrains.intellij") version "1.1.2"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jsoup:jsoup:1.14.3")
    implementation("net.pearx.kasechange:kasechange-jvm:1.3.0")
    testImplementation("io.mockk:mockk:1.12.0")
}

repositories {
    mavenCentral()
}

intellij {
    version.set("2019.3")
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
        channels.set(listOf("beta"))
    }
    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
