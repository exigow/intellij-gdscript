package gdscript.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project
import gdscript.lang.IconCatalog


class GodotConfigurationType : ConfigurationType {

    override fun getIcon() =
        IconCatalog.GODOT_FILE

    override fun getConfigurationTypeDescription() =
        "Godot project run configuration"

    override fun getId() =
        "GODOT_CONFIGURATION"

    override fun getDisplayName() =
        "Godot"

    override fun getConfigurationFactories(): Array<ConfigurationFactory> =
        arrayOf(GodotConfigurationFactory(this))

    private class GodotConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {

        override fun createTemplateConfiguration(project: Project): RunConfiguration =
            GodotRunConfiguration(project, this)

    }

}