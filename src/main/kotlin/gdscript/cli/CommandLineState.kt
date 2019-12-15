package gdscript.cli

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.KillableColoredProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment

internal class CommandLineState(config: CommandLineRunConfiguration, environment: ExecutionEnvironment)
    : CommandLineState(environment) {

    private val command = GeneralCommandLine()
        .withExePath(config.executablePath)
        .withWorkDirectory(config.workingDirectory)
        .withParameters(decodeParameters(config.programParameters))
        .withEnvironment(config.envs)

    override fun startProcess(): ProcessHandler =
        KillableColoredProcessHandler(command)
            .also { ProcessTerminatedListener.attach(it, environment.project) }

    private fun decodeParameters(params: String) =
        params.split(" ").filterNot { it.isBlank() }

}