plugins {
    java
    antlr
    id("org.jetbrains.kotlin.jvm").version("1.3.21")
    id("org.jetbrains.intellij").version("0.4.9")
    id("de.undercouch.download").version("4.0.0")
}

dependencies {
    antlr("org.antlr:antlr4:4.7.2")
    compile("com.yuvalshavit:antlr-denter:1.1")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    compile("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.9")
    implementation("org.antlr:antlr4-intellij-adaptor:0.1")
    testCompile("junit:junit:4.11")
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
    generateGrammarSource {
        val path = "gdscript/grammar"
        outputDirectory = file("src/main/java/$path")
        val pack = path.replace("/", ".")
        arguments = listOf("-package", pack, "-no-listener", "-no-visitor")
    }

}
