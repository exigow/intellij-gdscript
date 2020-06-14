import org.gradle.api.Project
import org.gradle.kotlin.dsl.register
import tasks.DownloadDocumentation
import tasks.GenerateCompletion

fun Project.registerAdditionalTasks() {
    tasks.register<GenerateCompletion>("generateCompletion") {
        dependsOn("downloadDocumentation")
    }
    tasks.register<DownloadDocumentation>("downloadDocumentation")
}