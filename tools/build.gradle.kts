plugins {
    java
    kotlin("jvm")
    application
}

dependencies {
    compile(project(":shared"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.1")
    implementation("org.jsoup:jsoup:1.12.1")
    implementation("com.google.code.gson:gson:2.8.5")
    compile(kotlin("stdlib"))
}

application {
    mainClassName = "main"
}
