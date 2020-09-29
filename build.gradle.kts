plugins {
    java
    id("org.jetbrains.kotlin.jvm").version("1.3.70")
    id("org.jetbrains.intellij").version("0.4.26")
}

dependencies {
    implementation("org.jsoup:jsoup:1.13.1")
    implementation("net.pearx.kasechange:kasechange-jvm:1.3.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.9.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.70")
    testImplementation("io.mockk:mockk:1.10.2")
}

repositories {
    jcenter()
    mavenCentral()
}

buildscript {
    repositories {
        maven("https://jetbrains.bintray.com/intellij-plugin-service")
    }
}

intellij {
    version = "2019.3"
    updateSinceUntilBuild = false
}

tasks {
    publishPlugin {
        token(project.property("publishPluginToken"))
        channels("stable")
    }
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
