package gdscript.execution

import BaseTest
import com.intellij.execution.configurations.RuntimeConfigurationWarning
import io.mockk.mockk
import io.mockk.verify
import org.jdom.Element
import utils.assertThrows
import java.io.File

class RunConfigurationTest : BaseTest() {

    fun `test minimal configuration`() {
        val config = newConfig()
        config.executable = TEMP_FILE
        config.workingDirectory = TEMP_FILE
        config.checkConfiguration()
    }

    fun `test exception is thrown on empty executable path`() {
        val config = newConfig()
        assertThrows<RuntimeConfigurationWarning>(
            { config.checkConfiguration() },
            "Executable is empty"
        )
    }

    fun `test exception is thrown on empty working directory`() {
        val config = newConfig()
        config.executable = TEMP_FILE
        assertThrows<RuntimeConfigurationWarning>(
            { config.checkConfiguration() },
            "Working directory is empty"
        )
    }

    fun `test serialization`() {
        val config = newConfig()
        config.executable = TEMP_FILE
        config.workingDirectory = TEMP_FILE
        config.parameters = "--script main.gd"
        val element = mockk<Element>(relaxed = true)
        config.writeExternal(element)
        verify { element.setAttribute("executable", TEMP_FILE) }
        verify { element.setAttribute("workingDirectory", TEMP_FILE) }
        verify { element.setAttribute("parameters", "--script main.gd") }
    }

    private fun newConfig(): RunConfiguration {
        val factory = RunConfigurationFactory(RunConfigurationType())
        return RunConfiguration(environment.project, factory)
    }

    private companion object {

        val TEMP_FILE: String =
            File.createTempFile("test", null)
                .also { it.setExecutable(true) }
                .also { it.deleteOnExit() }
                .path

    }

}
