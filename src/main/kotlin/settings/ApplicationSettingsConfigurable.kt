package settings

import version.VersionService
import com.intellij.openapi.components.service
import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.VerticalFlowLayout
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel

class ApplicationSettingsConfigurable : SearchableConfigurable {

    private val settings = service<ApplicationSettings>()
    private val versionList = initVersions()

    override fun getDisplayName() =
        "GDScript"

    override fun isModified() =
        settings.versionId != versionList.selectedItem

    override fun getId() =
        "ApplicationSettingsConfigurable"

    override fun apply() {
        settings.versionId = versionList.selectedItem as String
    }

    override fun createComponent(): JComponent {
        val panel = JPanel(VerticalFlowLayout())
        panel.add(LabeledComponent.create(versionList, "API version:").also { it.labelLocation = BorderLayout.WEST })
        return panel
    }
    private fun initVersions(): ComboBox<String> {
        val allVersions = VersionService.all().map { it.versionId }.toTypedArray()
        val combo = ComboBox(allVersions)
        combo.selectedItem = settings.versionId
        return combo
    }

}