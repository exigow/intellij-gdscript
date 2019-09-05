plugins {
    java
    antlr
    kotlin("jvm")
    id("org.jetbrains.intellij").version("0.4.9")
}

dependencies {
    compile(project(":shared"))
    antlr("org.antlr:antlr4:4.7.2")
    implementation("com.yuvalshavit:antlr-denter:1.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.9")
    implementation("org.antlr:antlr4-intellij-adaptor:0.1")
}

intellij {
    version = "2019.2"
    downloadSources = true
    updateSinceUntilBuild = false
}

repositories {
    mavenCentral()
}

tasks {
    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    /*compileKotlin {
        dependsOn(generateGrammarSource)
    }*/
    generateGrammarSource {
        outputDirectory = file("src/main/java/gdscript/grammar")
        arguments = listOf("-package", "gdscript.grammar", "-no-listener", "-no-visitor")
    }
}
