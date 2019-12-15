package gdscript.cli

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project
import gdscript.lang.IconCatalog


class CommandLineConfigurationType : ConfigurationType {

    override fun getIcon() =
        IconCatalog.GODOT_FILE

    override fun getConfigurationTypeDescription() =
        "Godot run configuration"

    override fun getId() =
        "GODOT_CONFIGURATION"

    override fun getDisplayName() =
        "Godot"

    override fun getConfigurationFactories(): Array<ConfigurationFactory> =
        arrayOf(GodotConfigurationFactory(this))

    private class GodotConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {

        override fun createTemplateConfiguration(project: Project): RunConfiguration =
            CommandLineRunConfiguration(project, this)

    }

}