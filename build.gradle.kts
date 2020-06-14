plugins {
    java
    kotlin("jvm") version "1.3.41"
    id("org.jetbrains.intellij").version("0.4.9")
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.9")
    implementation("net.pearx.kasechange:kasechange-jvm:1.1.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.9.0")
    testImplementation("io.mockk:mockk:1.9.3")
}

repositories {
    jcenter()
    mavenCentral()
}

intellij {
    version = "2019.3"
    updateSinceUntilBuild = false
}

tasks {
    registerAdditionalTasks()
    publishPlugin {
        token(project.property("publishPluginToken"))
        channels("stable")
    }
    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
