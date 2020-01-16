package gdscript.cli.producers


import com.intellij.openapi.vfs.VirtualFile
import gdscript.cli.RunConfiguration


class RunScriptProducer : RunFileProducer() {

    override fun isApplicable(file: VirtualFile) =
        file.extension == "gd"

    override fun setupConfiguration(configuration: RunConfiguration, contextFile: VirtualFile) {
        configuration.name = contextFile.nameWithoutExtension
        configuration.executablePath = "/usr/bin/godot"
        configuration.workingDirectory = contextFile.parent.path
        configuration.parameters = "--script ${contextFile.name}"
    }

}