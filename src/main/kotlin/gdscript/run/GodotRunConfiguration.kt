package gdscript.run

import com.intellij.execution.CommonProgramRunConfigurationParameters
import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.ui.CommonProgramParametersPanel
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import java.io.File
import javax.swing.JComponent

// todo configs are not saved properly after restart (not working)
class GodotRunConfiguration(project: Project, factory: ConfigurationFactory)
    : LocatableConfigurationBase<RunProfileState>(project, factory), CommonProgramRunConfigurationParameters {

    private var workingDir: String = ""
    private var params: String = ""

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> =
        object : SettingsEditor<GodotRunConfiguration>() {

            private val form = CommonProgramParametersPanel()

            override fun resetEditorFrom(config: GodotRunConfiguration) {
                form.reset(config)
            }

            override fun applyEditorTo(config: GodotRunConfiguration) {
                form.applyTo(config)
            }

            override fun createEditor(): JComponent =
                form

        }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return GodotCommandLineState(this, environment)
    }

    override fun getWorkingDirectory(): String =
        workingDir

    override fun setWorkingDirectory(value: String?) {
        workingDir = value.orEmpty()
    }

    override fun getProgramParameters(): String? =
        params

    override fun setProgramParameters(value: String?) {
        params = value.orEmpty()
    }

    override fun checkConfiguration() {
        val directory = File(workingDir)
        if (!directory.exists())
            throw RuntimeConfigurationException("Working directory is not a file.")
        if (!directory.isDirectory)
            throw RuntimeConfigurationException("Working directory is not a directory.")
    }

    override fun getEnvs(): MutableMap<String, String> = mutableMapOf()

    override fun setEnvs(envs: MutableMap<String, String>) {}

    override fun isPassParentEnvs(): Boolean = false

    override fun setPassParentEnvs(passParentEnvs: Boolean) {}

}