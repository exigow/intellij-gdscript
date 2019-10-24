plugins {
    kotlin("jvm") version "1.3.50"
}

allprojects {
    registerGenerateCompletionDataTask()
    repositories {
        jcenter()
        mavenCentral()
    }
}
