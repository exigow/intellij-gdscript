package gdscript.run


import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.openapi.util.Ref
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.newvfs.impl.NullVirtualFile
import com.intellij.psi.PsiElement


class GodotRunConfigurationProducer : LazyRunConfigurationProducer<GodotRunConfiguration>() {

    override fun getConfigurationFactory(): ConfigurationFactory {
        return GodotConfigurationType().configurationFactories[0] // fixme
    }

    override fun setupConfigurationFromContext(configuration: GodotRunConfiguration, context: ConfigurationContext, sourceElement: Ref<PsiElement>): Boolean {
        val file = context.psiLocation?.containingFile?.virtualFile
            ?: NullVirtualFile.INSTANCE
        configuration.configureByFile(file)
        return isNotProjectFile(file)
    }

    private fun GodotRunConfiguration.configureByFile(file: VirtualFile) {
        workingDirectory = file.parent?.path.orEmpty()
        programParameters = file.name // todo scenes in subdirectories
    }

    override fun isConfigurationFromContext(configuration: GodotRunConfiguration, context: ConfigurationContext) =
        false

    private fun isNotProjectFile(file: VirtualFile?) =
        file?.extension == "tscn"

}