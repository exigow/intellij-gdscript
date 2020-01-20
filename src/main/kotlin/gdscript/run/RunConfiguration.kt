package gdscript.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.KillableColoredProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.project.Project
import com.intellij.util.execution.ParametersListUtil
import com.intellij.util.io.exists
import org.jdom.Element
import java.nio.file.Paths

class RunConfiguration(project: Project, factory: ConfigurationFactory)
    : LocatableConfigurationBase<RunProfileState>(project, factory) {

    var executablePath = ""
    var workingDirectory = ""
    var parameters = ""

    override fun checkConfiguration() {
        if (executablePath.isEmpty())
            throw RuntimeConfigurationException("Executable path is empty.")
        if (workingDirectory.isEmpty())
            throw RuntimeConfigurationException("Working directory is empty.")
        if (!Paths.get(executablePath).exists())
            throw RuntimeConfigurationException("Executable path don't exist.")
    }

    override fun getConfigurationEditor() =
        RunConfigurationPanel(project)

    override fun getState(executor: Executor, environment: ExecutionEnvironment) =
        object : CommandLineState(environment) {

            override fun startProcess(): ProcessHandler {
                val cmd = GeneralCommandLine()
                    .withExePath(executablePath)
                    .withWorkDirectory(workingDirectory)
                    .withParameters(ParametersListUtil.parse(parameters))
                return KillableColoredProcessHandler(cmd)
                    .also { ProcessTerminatedListener.attach(it, environment.project) }
            }

        }

    override fun readExternal(element: Element) {
        executablePath = element.getAttributeValue(EXECUTABLE_TAG).orEmpty()
        workingDirectory = element.getAttributeValue(WORKING_DIRECTORY_KEY).orEmpty()
        parameters = element.getAttributeValue(PARAMETERS_KEY).orEmpty()
    }

    override fun writeExternal(element: Element) {
        element.setAttribute(EXECUTABLE_TAG, executablePath)
        element.setAttribute(WORKING_DIRECTORY_KEY, workingDirectory)
        element.setAttribute(PARAMETERS_KEY, parameters)
    }

    private companion object {

        const val EXECUTABLE_TAG = "executablePath"
        const val WORKING_DIRECTORY_KEY = "workingDirectory"
        const val PARAMETERS_KEY = "parameters"

    }

}
