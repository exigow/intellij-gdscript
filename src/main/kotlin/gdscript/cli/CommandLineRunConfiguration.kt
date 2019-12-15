package gdscript.cli

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

class CommandLineRunConfiguration(project: Project, factory: ConfigurationFactory)
    : LocatableConfigurationBase<RunProfileState>(project, factory) {

    var executablePath: String = ""
    var workingDirectory: String = ""
    var parameters: List<String> = emptyList()

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> =
        CommandLineSettings(project)

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState =
        CommandLineState(this, environment)

    override fun checkConfiguration() {
        if (executablePath.isEmpty())
            throw RuntimeConfigurationException("Executable path is empty.")
        if (workingDirectory.isEmpty())
            throw RuntimeConfigurationException("Working directory is empty.")
    }

}
