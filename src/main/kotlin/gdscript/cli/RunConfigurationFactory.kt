package gdscript.cli

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.openapi.project.Project
import gdscript.lang.IconCatalog

class RunConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {

    override fun createTemplateConfiguration(project: Project) =
        RunConfiguration(project, this)

    override fun getIcon() =
        IconCatalog.RUN

}
