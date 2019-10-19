plugins {
    java
    antlr
    kotlin("jvm")
    id("org.jetbrains.intellij").version("0.4.9")
}

dependencies {
    compile(project(":api"))
    antlr("org.antlr:antlr4:4.7.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.9")
    implementation("org.antlr:antlr4-intellij-adaptor:0.1")
}

intellij {
    version = "2019.2"
}

repositories {
    mavenCentral()
}

sourceSets["main"].java.srcDir("build/generated-src/antlr/main")

tasks {
    compileKotlin {
        dependsOn(generateGrammarSource)
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    generateGrammarSource {
        arguments = listOf("-no-listener", "-no-visitor")
    }
}
