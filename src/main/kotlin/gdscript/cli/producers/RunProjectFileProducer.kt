package gdscript.cli.producers


import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import gdscript.cli.CommandLineRunConfiguration
import gdscript.cli.CommandLineConfigurationType


class RunProjectFileProducer : LazyRunConfigurationProducer<CommandLineRunConfiguration>() {

    override fun getConfigurationFactory(): ConfigurationFactory =
        CommandLineConfigurationType().configurationFactories[0]

    override fun setupConfigurationFromContext(configuration: CommandLineRunConfiguration, context: ConfigurationContext, sourceElement: Ref<PsiElement>): Boolean {
        val file = context.psiLocation?.containingFile?.virtualFile
            ?: return false
        if (file.name != "project.godot")
            return false
        configuration.name = "Project " + file.parent.name
        configuration.executablePath = "/usr/bin/godot"
        configuration.workingDirectory = file.parent?.path.orEmpty()
        return true
    }

    override fun isConfigurationFromContext(configuration: CommandLineRunConfiguration, context: ConfigurationContext) =
        false

}