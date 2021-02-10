plugins {
    java
    id("org.jetbrains.kotlin.jvm").version("1.4.21")
    id("org.jetbrains.intellij").version("0.4.26")
    id("org.jetbrains.grammarkit").version("2020.3.2")
}

dependencies {
    implementation("org.jsoup:jsoup:1.13.1")
    implementation("net.pearx.kasechange:kasechange-jvm:1.3.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.9.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.21")
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

grammarKit {
    jflexRelease = "1.7.0-1"
    grammarKitRelease = "2020.3.1"
}

sourceSets {
    main {
        java {
            srcDir("src/main/gen")
        }
    }
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
    named("compileKotlin") {
        dependsOn("compileGdscriptParser")
    }
    register<org.jetbrains.grammarkit.tasks.GenerateParser>("compileGdscriptParser") {
        dependsOn("compileGdscriptLexer")
        source = "src/main/kotlin/gdscript/Script.bnf"
        targetRoot = "src/main/gen"
        pathToParser = "/gdscript/parser/ScriptParser.java"
        pathToPsiRoot = "/gdscript/psi"
        purgeOldFiles = true
    }
    register<org.jetbrains.grammarkit.tasks.GenerateLexer>("compileGdscriptLexer") {
        source = "src/main/kotlin/gdscript/Script.flex"
        targetDir = "src/main/gen/gdscript/lexer/"
        targetClass = "ScriptLexer"
        purgeOldFiles = true
    }
}
