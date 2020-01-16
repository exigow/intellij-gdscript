package gdscript.cli

import com.intellij.execution.configurations.ConfigurationTypeUtil
import gdscript.BaseTest


class RunConfigurationTypeTest : BaseTest() {

    fun `test ID is not changed between releases`() {
        val type = ConfigurationTypeUtil.findConfigurationType(RunConfigurationType::class.java)
        assertEquals("godotConfiguration", type.id)
    }

}