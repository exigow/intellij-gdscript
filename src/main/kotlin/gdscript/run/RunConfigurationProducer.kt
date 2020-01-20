package gdscript.run

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.openapi.util.SystemInfo
import com.intellij.psi.PsiElement
import java.io.File

class RunConfigurationProducer : LazyRunConfigurationProducer<RunConfiguration>() {

    override fun setupConfigurationFromContext(
        config: RunConfiguration, context: ConfigurationContext, sourceElement: Ref<PsiElement>
    ): Boolean {
        val file = retrieveFile(context)
            ?: return false
        config.executable = determineExecutable(context)
        when {
            file.extension == "tscn" -> {
                config.name = file.nameWithoutExtension
                config.workingDirectory = file.parent.path
                config.parameters = file.name
                return true
            }
            file.extension == "gd" -> {
                config.name = file.nameWithoutExtension
                config.workingDirectory = file.parent.path
                config.parameters = "--script ${file.name}"
                return true
            }
            file.name == "project.godot" -> {
                config.name = file.parent.name
                config.workingDirectory = file.parent.path
                return true
            }
        }
        return false
    }

    override fun getConfigurationFactory() =
        RunConfigurationFactory(RunConfigurationType())

    override fun isConfigurationFromContext(config: RunConfiguration, context: ConfigurationContext) =
        true

    private fun retrieveFile(context: ConfigurationContext) =
        context.psiLocation?.containingFile?.virtualFile

    private fun determineExecutable(context: ConfigurationContext) =
        findWorkingExecutable(context)
            ?: getDefaultExecutableBySystem()

    private fun findWorkingExecutable(context: ConfigurationContext) = context
        .runManager
        .allSettings
        .mapNotNull { it.configuration as? RunConfiguration }
        .map { it.executable }
        .find { File(it).exists() }

    private fun getDefaultExecutableBySystem() = when {
        SystemInfo.isLinux -> "/usr/bin/godot"
        SystemInfo.isWindows -> "C:\\Godot.exe"
        else -> ""
    }

}