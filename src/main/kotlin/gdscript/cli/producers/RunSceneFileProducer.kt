package gdscript.cli.producers


import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import gdscript.cli.CommandLineConfigurationType
import gdscript.cli.CommandLineRunConfiguration


class RunSceneFileProducer : LazyRunConfigurationProducer<CommandLineRunConfiguration>() {

    override fun getConfigurationFactory(): ConfigurationFactory =
        CommandLineConfigurationType().configurationFactories[0]

    override fun setupConfigurationFromContext(configuration: CommandLineRunConfiguration, context: ConfigurationContext, sourceElement: Ref<PsiElement>): Boolean {
        val file = context.psiLocation?.containingFile?.virtualFile
            ?: return false
        if (file.extension != "tscn")
            return false
        configuration.name = "Scene " + file.name
        configuration.executablePath = "/usr/bin/godot"
        configuration.workingDirectory = file.parent?.path.orEmpty()
        configuration.programParameters = file.name
        return true
    }

    override fun isConfigurationFromContext(configuration: CommandLineRunConfiguration, context: ConfigurationContext) =
        false

}