plugins {
    java
    antlr
    kotlin("jvm") version "1.3.41"
    id("org.jetbrains.intellij").version("0.4.9")
}

dependencies {
    antlr("org.antlr:antlr4:4.8-1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.9")
    implementation("org.antlr:antlr4-intellij-adaptor:0.1")
    implementation("net.pearx.kasechange:kasechange-jvm:1.1.0")
    testImplementation("io.mockk:mockk:1.9.3")
}

repositories {
    jcenter()
    mavenCentral()
}

intellij {
    version = "2019.2"
    updateSinceUntilBuild = false
}

tasks {
    registerAdditionalTasks()
    publishPlugin {
        token(project.property("publishPluginToken"))
        channels("beta")
    }
    compileKotlin {
        dependsOn(generateGrammarSource)
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    generateGrammarSource {
        arguments = listOf(
            "-no-listener",
            "-no-visitor",
            "-lib", "src/main/antlr/gdscript",
            "-package", "gdscript"
        )
    }
}
