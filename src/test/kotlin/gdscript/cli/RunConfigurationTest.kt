package gdscript.cli

import com.intellij.execution.configurations.RuntimeConfigurationException
import gdscript.BaseTest
import io.mockk.mockk
import io.mockk.verify
import org.jdom.Element
import uitlities.assertExceptionThrown


class RunConfigurationTest : BaseTest() {

    fun `test minimal configuration`() {
        val config = newConfig()
        config.executablePath = "/usr/bin/godot"
        config.workingDirectory = "/game"
        config.checkConfiguration()
    }

    fun `test exception is thrown on empty executable path`() {
        val config = newConfig()
        assertExceptionThrown<RuntimeConfigurationException>(
            { config.checkConfiguration() },
            "Executable path is empty."
        )
    }

    fun `test exception is thrown on empty working directory`() {
        val config = newConfig()
        config.executablePath = "/usr/bin/godot"
        assertExceptionThrown<RuntimeConfigurationException>(
            { config.checkConfiguration() },
            "Working directory is empty."
        )
    }

    fun `test serialization`() {
        val config = newConfig()
        config.executablePath = "/usr/bin/godot"
        config.workingDirectory = "/game"
        config.parameters = "scene.ts"
        val element = mockk<Element>(relaxed = true)
        config.writeExternal(element)
        verify { element.setAttribute("executablePath", "/usr/bin/godot") }
        verify { element.setAttribute("workingDirectory", "/game") }
        verify { element.setAttribute("parameters", "scene.ts") }
    }

    private fun newConfig(): RunConfiguration {
        val factory = RunConfigurationFactory(RunConfigurationType())
        return RunConfiguration(environment.project, factory)
    }

}
