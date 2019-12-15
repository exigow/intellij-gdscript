package gdscript.cli

import com.intellij.execution.ui.MacroComboBoxWithBrowseButton
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.VerticalFlowLayout
import com.intellij.ui.RawCommandLineEditor
import com.intellij.util.PathUtil
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel

class CommandLineConfigurationPanel(private val project: Project) : JPanel() {

    private val executablePathChooser = createFileChooser()
    private val workingDirectoryChooser = createFileChooser()
    private val parametersEditor = RawCommandLineEditor()

    init {
        layout = VerticalFlowLayout(VerticalFlowLayout.MIDDLE, 0, 5, true, false)
        addLabeledComponent("Godot executable:", executablePathChooser)
        addLabeledComponent("Working directory:", workingDirectoryChooser)
        addLabeledComponent("Parameters:", parametersEditor)
    }

    fun reset(config: CommandLineRunConfiguration) {
        executablePathChooser.text = PathUtil.toSystemDependentName(config.executablePath)
        workingDirectoryChooser.text = PathUtil.toSystemDependentName(config.workingDirectory)
        parametersEditor.text = config.parameters.joinToString(" ")
    }

    fun applyTo(config: CommandLineRunConfiguration) {
        config.executablePath = executablePathChooser.text
        config.workingDirectory = workingDirectoryChooser.text
        config.parameters = parametersEditor.text.split(" ")
    }

    private fun addLabeledComponent(label: String, component: JComponent) {
        val labeled = LabeledComponent.create(component, label)
        labeled.labelLocation = BorderLayout.WEST
        add(labeled)
    }

    private fun createFileChooser(): MacroComboBoxWithBrowseButton {
        val fileChooser = FileChooserDescriptorFactory.createSingleFolderDescriptor()
            .also { it.title = "Select file" }
        return MacroComboBoxWithBrowseButton(fileChooser, project)
    }

}

