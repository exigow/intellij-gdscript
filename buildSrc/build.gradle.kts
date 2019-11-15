plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("org.jsoup:jsoup:1.12.1")
}