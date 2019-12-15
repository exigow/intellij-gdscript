package gdscript.cli

import com.intellij.execution.configurations.ConfigurationTypeUtil
import gdscript.BaseTest


class CommandLineConfigurationTypeTest : BaseTest() {

    fun `test the ID to ensure backward compatibility`() {
        val configType = ConfigurationTypeUtil.findConfigurationType(CommandLineConfigurationType::class.java)
        assertEquals("GODOT_CONFIGURATION", configType.id)
    }

}