plugins {
    java
    antlr
    kotlin("jvm")
    id("org.jetbrains.intellij").version("0.4.9")
}

dependencies {
    compile(project(":api"))
    antlr("org.antlr:antlr4:4.7.2")
    implementation("com.yuvalshavit:antlr-denter:1.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.9")
    implementation("org.antlr:antlr4-intellij-adaptor:0.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.50")
}

intellij {
    version = "2019.2"
    downloadSources = true
    updateSinceUntilBuild = false
}

repositories {
    mavenCentral()
}

sourceSets["main"].java.srcDir("build/generated-src/antlr/main")

tasks {
    compileKotlin {
        dependsOn(generateGrammarSource)
    }
    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    generateGrammarSource {
        arguments = listOf("-no-listener", "-no-visitor")
    }
}
