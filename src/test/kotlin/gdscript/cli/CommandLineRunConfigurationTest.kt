package gdscript.cli

import com.intellij.execution.configurations.RuntimeConfigurationException
import gdscript.BaseTest
import uitlities.assertExceptionThrown


class CommandLineRunConfigurationTest : BaseTest() {

    fun `test empty configuration throws exception when working directory empty`() {
        val config = createConfig()
        config.executablePath = "godot"
        assertExceptionThrown<RuntimeConfigurationException> {
            config.checkConfiguration()
        }
    }

    fun `test no exception when working directory is set`() {
        val config = createConfig()
        config.executablePath = "godot"
        config.workingDirectory = "game"
        config.checkConfiguration()
    }

    private fun createConfig() =
        CommandLineRunConfiguration(environment.project, CommandLineConfigurationType().configurationFactories[0])

}
