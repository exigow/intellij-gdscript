package run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.openapi.project.Project
import common.Icons

class RunConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {

    override fun createTemplateConfiguration(project: Project) =
        RunConfiguration(project, this)

    override fun getIcon() =
        Icons.RUN

    override fun getId() =
        RunConfigurationType.ID

}
