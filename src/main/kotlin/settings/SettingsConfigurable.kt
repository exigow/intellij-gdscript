package settings

import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.openapi.ui.VerticalFlowLayout
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JPanel

class SettingsConfigurable : SearchableConfigurable {

    private val lspCheckbox = createCheckbox()

    override fun getDisplayName() = "GDScript"

    override fun isModified(): Boolean {
        val uiState = readControlsState()
        val componentState = SettingsComponent.INSTANCE.state
        return uiState != componentState
    }

    override fun getId() = "gdscript.settings"

    override fun apply() {
        val state = readControlsState()
        SettingsComponent.INSTANCE.loadState(state)
    }

    override fun createComponent(): JComponent? {
        return JPanel().apply {
            layout = VerticalFlowLayout()
            add(lspCheckbox)
        }
    }

    private fun readControlsState(): Settings {
        return Settings(lspEnabled = lspCheckbox.isSelected)
    }

    private fun createCheckbox(): JCheckBox {
        val initialValue = SettingsComponent.INSTANCE.settings.lspEnabled
        return JCheckBox("LSP features (experimental)", initialValue)
    }

}