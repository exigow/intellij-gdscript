package settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import version.VersionService

@State(name = "ApplicationSettings", storages = [(Storage("gdscript.xml"))])
class ApplicationSettings(
    var versionId: String = VersionService.DEFAULT_VERSION
) : PersistentStateComponent<ApplicationSettings> {

    override fun getState() = this

    override fun loadState(other: ApplicationSettings) {
        XmlSerializerUtil.copyBean(other, this)
    }

}
