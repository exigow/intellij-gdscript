package gdscript.run

import com.intellij.execution.configurations.RuntimeConfigurationError
import gdscript.BaseTest
import io.mockk.mockk
import io.mockk.verify
import org.jdom.Element
import uitlities.assertThrows
import java.io.File

class RunConfigurationTest : BaseTest() {

    fun `test minimal configuration`() {
        val config = newConfig()
        config.executable = TEMPORAL_FILE
        config.workingDirectory = TEMPORAL_FILE
        config.checkConfiguration()
    }

    fun `test exception is thrown on empty executable path`() {
        val config = newConfig()
        assertThrows<RuntimeConfigurationError>(
            { config.checkConfiguration() },
            "Executable is empty"
        )
    }

    fun `test exception is thrown on empty working directory`() {
        val config = newConfig()
        config.executable = TEMPORAL_FILE
        assertThrows<RuntimeConfigurationError>(
            { config.checkConfiguration() },
            "Working directory is empty"
        )
    }

    fun `test serialization`() {
        val config = newConfig()
        config.executable = TEMPORAL_FILE
        config.workingDirectory = TEMPORAL_FILE
        config.parameters = "--script main.gd"
        val element = mockk<Element>(relaxed = true)
        config.writeExternal(element)
        verify { element.setAttribute("executable", TEMPORAL_FILE) }
        verify { element.setAttribute("workingDirectory", TEMPORAL_FILE) }
        verify { element.setAttribute("parameters", "--script main.gd") }
    }

    private fun newConfig(): RunConfiguration {
        val factory = RunConfigurationFactory(RunConfigurationType())
        return RunConfiguration(environment.project, factory)
    }

    private companion object {

        val TEMPORAL_FILE: String =
            File.createTempFile("test", null)
                .also { it.setExecutable(true) }
                .also { it.deleteOnExit() }
                .path

    }

}
