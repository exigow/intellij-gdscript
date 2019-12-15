package gdscript.run

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.KillableColoredProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment


class GodotCommandLineState(config: GodotRunConfiguration, environment: ExecutionEnvironment)
    : CommandLineState(environment) {

    private val command = GeneralCommandLine()
        .withExePath("/usr/bin/godot") // fixme
        .withParameters(config.programParameters)
        .withWorkDirectory(config.workingDirectory)

    override fun startProcess(): ProcessHandler =
        KillableColoredProcessHandler(command)
            .also { ProcessTerminatedListener.attach(it, environment.project) }

}