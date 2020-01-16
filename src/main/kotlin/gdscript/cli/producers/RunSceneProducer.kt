package gdscript.cli.producers


import com.intellij.openapi.vfs.VirtualFile
import gdscript.cli.RunConfiguration


class RunSceneProducer : RunFileProducer() {

    override fun isApplicable(file: VirtualFile) =
        file.extension == "tscn"

    override fun setupConfiguration(configuration: RunConfiguration, contextFile: VirtualFile) {
        configuration.name = contextFile.nameWithoutExtension
        configuration.executablePath = "/usr/bin/godot"
        configuration.workingDirectory = contextFile.parent.path
        configuration.parameters = contextFile.name
    }

}