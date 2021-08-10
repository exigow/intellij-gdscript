plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.5.10"
    id("org.jetbrains.intellij") version "1.1.4"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jsoup:jsoup:1.13.1")
    implementation("net.pearx.kasechange:kasechange-jvm:1.3.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.9.0")
    testImplementation("io.mockk:mockk:1.10.2")
}

repositories {
    mavenCentral()
}

intellij {
    version.set("2019.3")
    updateSinceUntilBuild.set(false)
}

tasks {
    publishPlugin {
        val publishPluginToken = project.properties["publishPluginToken"] as String
        token.set(publishPluginToken)
        channels.set(listOf("stable"))
    }
    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
