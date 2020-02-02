import org.gradle.api.Project
import org.gradle.kotlin.dsl.register
import tasks.DownloadDocumentation
import tasks.GenerateCompletion
import tasks.GenerateLexer

fun Project.registerAdditionalTasks() {
    tasks.register<GenerateCompletion>("generateCompletion") {
        dependsOn("downloadDocumentation")
    }
    tasks.register<GenerateLexer>("generateLexer") {
        dependsOn("downloadDocumentation")
    }
    tasks.register<DownloadDocumentation>("downloadDocumentation")
}