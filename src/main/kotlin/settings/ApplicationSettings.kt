package settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(name = "ApplicationSettings", storages = [(Storage("gdscript.xml"))])
class ApplicationSettings(
    var lspEnabled: Boolean = false
) : PersistentStateComponent<ApplicationSettings> {

    override fun getState() = this

    override fun loadState(other: ApplicationSettings) {
        XmlSerializerUtil.copyBean(other, this)
    }

}