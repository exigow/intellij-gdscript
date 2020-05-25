package settings

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.openapi.ui.VerticalFlowLayout
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JPanel

class ApplicationSettingsConfigurable : SearchableConfigurable {

    private val settings = ServiceManager.getService(ApplicationSettings::class.java)
    private val lspCheckbox = JCheckBox("LSP features (experimental)", settings.lspEnabled)

    override fun getDisplayName() = "GDScript"

    override fun isModified() =
        settings.lspEnabled != lspCheckbox.isSelected

    override fun getId() = "ApplicationSettingsConfigurable"

    override fun apply() {
        settings.lspEnabled = lspCheckbox.isSelected
    }

    override fun createComponent(): JComponent? {
        return JPanel().apply {
            layout = VerticalFlowLayout()
            add(lspCheckbox)
        }
    }

}