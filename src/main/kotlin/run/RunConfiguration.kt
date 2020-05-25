package run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.KillableColoredProcessHandler
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.project.Project
import com.intellij.util.execution.ParametersListUtil
import org.jdom.Element
import run.console.ConsoleLinkFilter

class RunConfiguration(project: Project, factory: ConfigurationFactory)
    : LocatableConfigurationBase<RunProfileState>(project, factory) {

    var executable = ""
    var workingDirectory = ""
    var parameters = ""

    override fun checkConfiguration() {
        if (executable.isEmpty())
            throw RuntimeConfigurationWarning("Executable is empty")
        if (workingDirectory.isEmpty())
            throw RuntimeConfigurationWarning("Working directory is empty")
    }

    override fun getConfigurationEditor() =
        RunConfigurationPanel(project)

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState =
        object : CommandLineState(environment) {

            override fun startProcess() =
                KillableColoredProcessHandler(buildCommand())
                    .also { ProcessTerminatedListener.attach(it, environment.project) }

        }.apply {
            addConsoleFilters(ConsoleLinkFilter(project, workingDirectory))
        }

    override fun readExternal(element: Element) {
        executable = element.getAttributeValue(EXECUTABLE_TAG).orEmpty()
        workingDirectory = element.getAttributeValue(WORKING_DIRECTORY_KEY).orEmpty()
        parameters = element.getAttributeValue(PARAMETERS_KEY).orEmpty()
    }

    override fun writeExternal(element: Element) {
        element.setAttribute(EXECUTABLE_TAG, executable)
        element.setAttribute(WORKING_DIRECTORY_KEY, workingDirectory)
        element.setAttribute(PARAMETERS_KEY, parameters)
    }

    private fun buildCommand() =
        GeneralCommandLine()
            .withExePath(executable)
            .withWorkDirectory(workingDirectory)
            .withParameters(ParametersListUtil.parse(parameters))

    private companion object {

        const val EXECUTABLE_TAG = "executable"
        const val WORKING_DIRECTORY_KEY = "workingDirectory"
        const val PARAMETERS_KEY = "parameters"

    }

}
