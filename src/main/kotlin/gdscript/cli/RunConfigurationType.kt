package gdscript.cli

import com.intellij.execution.configurations.ConfigurationType
import gdscript.lang.IconCatalog


class RunConfigurationType : ConfigurationType {

    override fun getIcon() =
        IconCatalog.GODOT_FILE

    override fun getConfigurationTypeDescription() =
        "Godot run configuration"

    override fun getId() =
        "godotConfiguration"

    override fun getDisplayName() =
        "Godot"

    override fun getConfigurationFactories() =
        arrayOf(RunConfigurationFactory(this))

}