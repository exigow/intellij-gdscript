package gdscript.cli

import com.intellij.execution.CommonProgramRunConfigurationParameters
import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

class CommandLineRunConfiguration(project: Project, factory: ConfigurationFactory)
    : LocatableConfigurationBase<RunProfileState>(project, factory), CommonProgramRunConfigurationParameters {

    var executablePath: String = ""
    private var workingDirectory: String = ""
    private var programParameters: String = ""
    private var envs: Map<String, String> = emptyMap()

    override fun setWorkingDirectory(value: String?) {
        workingDirectory = value.orEmpty()
    }

    override fun getWorkingDirectory() =
        workingDirectory

    override fun setProgramParameters(value: String?) {
        programParameters = value.orEmpty()
    }

    override fun getProgramParameters() =
        programParameters

    override fun setEnvs(value: Map<String, String>) {
        envs = value
    }

    override fun getEnvs() =
        envs

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> =
        CommandLineSettings()

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState =
        CommandLineState(this, environment)

    override fun checkConfiguration() {
        if (executablePath.isEmpty())
            throw RuntimeConfigurationException("Executable path is empty.")
        if (workingDirectory.isEmpty())
            throw RuntimeConfigurationException("Working directory is empty.")
    }

    override fun isPassParentEnvs(): Boolean {
        // not implemented
        return false
    }

    override fun setPassParentEnvs(value: Boolean) {
        // not implemented
    }

}
