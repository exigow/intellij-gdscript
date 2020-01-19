package gdscript.run.producers

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import gdscript.run.RunConfiguration
import gdscript.run.RunConfigurationType

abstract class RunFileProducer : LazyRunConfigurationProducer<RunConfiguration>() {

    abstract fun isApplicable(file: VirtualFile): Boolean

    abstract fun setupConfiguration(configuration: RunConfiguration, contextFile: VirtualFile)

    override fun setupConfigurationFromContext(
        configuration: RunConfiguration,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>
    ): Boolean {
        val file = context.psiLocation?.containingFile?.virtualFile
            ?: return false
        if (isApplicable(file)) {
            setupConfiguration(configuration, file)
            return true
        }
        return false
    }

    override fun getConfigurationFactory() =
        RunConfigurationType().configurationFactories[0]

    override fun isConfigurationFromContext(config: RunConfiguration, context: ConfigurationContext) =
        true

}