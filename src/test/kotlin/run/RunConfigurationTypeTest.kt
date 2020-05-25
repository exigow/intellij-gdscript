package run

import BaseTest
import com.intellij.execution.configurations.ConfigurationTypeUtil


class RunConfigurationTypeTest : BaseTest() {

    fun `test ID is not changed between releases`() {
        val type = ConfigurationTypeUtil.findConfigurationType(RunConfigurationType::class.java)
        assertEquals("godotConfiguration", type.id)
    }

}