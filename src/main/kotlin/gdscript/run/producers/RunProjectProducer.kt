package gdscript.run.producers


import com.intellij.openapi.vfs.VirtualFile
import gdscript.run.RunConfiguration


class RunProjectProducer : RunFileProducer() {

    override fun isApplicable(file: VirtualFile) =
        file.name == "project.godot"

    override fun setupConfiguration(configuration: RunConfiguration, contextFile: VirtualFile) {
        configuration.name = contextFile.parent.nameWithoutExtension
        configuration.executablePath = "/usr/bin/godot"
        configuration.workingDirectory = contextFile.parent.path
    }

}