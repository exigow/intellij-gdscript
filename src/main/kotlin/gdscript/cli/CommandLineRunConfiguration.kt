package gdscript.cli

import com.intellij.execution.Executor
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.LocatableConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.configurations.RuntimeConfigurationException
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

class CommandLineRunConfiguration(project: Project, factory: ConfigurationFactory)
    : LocatableConfigurationBase<RunProfileState>(project, factory) {

    var executablePath: String = ""
    var workingDirectory: String = ""
    var parameters: List<String> = emptyList()

    override fun checkConfiguration() {
        if (executablePath.isEmpty())
            throw RuntimeConfigurationException("Executable path is empty.")
        if (workingDirectory.isEmpty())
            throw RuntimeConfigurationException("Working directory is empty.")
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState =
        CommandLineState(this, environment)

    override fun getConfigurationEditor() = object : SettingsEditor<CommandLineRunConfiguration>() {

        private val panel = CommandLineConfigurationPanel(project)

        override fun createEditor() = panel

        override fun resetEditorFrom(config: CommandLineRunConfiguration) =
            panel.reset(config)

        override fun applyEditorTo(config: CommandLineRunConfiguration) =
            panel.applyTo(config)

    }

}
