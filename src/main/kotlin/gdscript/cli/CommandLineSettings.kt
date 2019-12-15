package gdscript.cli

import com.intellij.execution.ui.CommonProgramParametersPanel
import com.intellij.openapi.options.SettingsEditor
import javax.swing.JComponent

internal class CommandLineSettings : SettingsEditor<CommandLineRunConfiguration>() {

    private val cliPanel = CommonProgramParametersPanel()

    override fun resetEditorFrom(config: CommandLineRunConfiguration) {
        cliPanel.reset(config)
    }

    override fun applyEditorTo(config: CommandLineRunConfiguration) {
        cliPanel.applyTo(config)
    }

    override fun createEditor(): JComponent =
        cliPanel

}
