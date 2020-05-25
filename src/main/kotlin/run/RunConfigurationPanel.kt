package run

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
            add(newComponent("Godot Engine executable:", executableComponent))
            add(newComponent("Working directory:", workingDirectoryComponent))
            add(newComponent("Parameters:", parametersComponent))
        }

    override fun applyEditorTo(config: RunConfiguration) {
        config.executable = executableComponent.text
        config.workingDirectory = workingDirectoryComponent.text
        config.parameters = parametersComponent.text
    }

    override fun resetEditorFrom(config: RunConfiguration) {
        executableComponent.text = config.executable
        workingDirectoryComponent.text = config.workingDirectory
        parametersComponent.text = config.parameters
    }

    private fun newComponent(label: String, component: JComponent) =
        LabeledComponent.create(component, label)
            .also { it.labelLocation = BorderLayout.WEST }

}

