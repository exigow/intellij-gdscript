package run

import com.intellij.execution.configurations.ConfigurationType
import common.Icons


class RunConfigurationType : ConfigurationType {

    override fun getIcon() =
        Icons.GDSCRIPT_FILE

    override fun getConfigurationTypeDescription() =
        "Godot run configuration"

    override fun getId() =
        ID

    override fun getDisplayName() =
        "Godot"

    override fun getConfigurationFactories() =
        arrayOf(RunConfigurationFactory(this))

    companion object {

        const val ID = "godotConfiguration"

    }

}
