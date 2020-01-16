package gdscript.cli

import com.intellij.execution.ui.MacroComboBoxWithBrowseButton
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory.createSingleFileOrExecutableAppDescriptor
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory.createSingleFolderDescriptor
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.VerticalFlowLayout
import com.intellij.ui.RawCommandLineEditor
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel

class RunConfigurationPanel(project: Project) : SettingsEditor<RunConfiguration>() {

    private val executableComponent = MacroComboBoxWithBrowseButton(createSingleFileOrExecutableAppDescriptor(), project)
    private val workingDirectoryComponent = MacroComboBoxWithBrowseButton(createSingleFolderDescriptor(), project)
    private val parametersComponent = RawCommandLineEditor()

    override fun createEditor() =
        JPanel().apply {
            layout = VerticalFlowLayout()
            add(newComponent("Godot executable:", executableComponent))
            add(newComponent("Working directory:", workingDirectoryComponent))
            add(newComponent("Executable parameters:", parametersComponent))
        }

    override fun applyEditorTo(config: RunConfiguration) {
        config.executablePath = executableComponent.text
        config.workingDirectory = workingDirectoryComponent.text
        config.parameters = parametersComponent.text
    }

    override fun resetEditorFrom(config: RunConfiguration) {
        executableComponent.text = config.executablePath
        workingDirectoryComponent.text = config.workingDirectory
        parametersComponent.text = config.parameters
    }

    private fun newComponent(label: String, component: JComponent) =
        LabeledComponent.create(component, label)
            .also { it.labelLocation = BorderLayout.WEST }

}

