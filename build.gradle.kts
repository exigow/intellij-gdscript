plugins {
    java
    id("org.jetbrains.kotlin.jvm").version("1.4.10")
    id("org.jetbrains.intellij").version("0.4.21")
}

dependencies {
    implementation("org.jsoup:jsoup:1.13.1")
    implementation("net.pearx.kasechange:kasechange-jvm:1.3.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.9.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.10")
    testImplementation("io.mockk:mockk:1.10.2")
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
