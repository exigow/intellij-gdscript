package settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(
    name = "ApplicationSettings",
    storages = [(Storage("gdscript.xml"))]
)
class SettingsComponent : PersistentStateComponent<Settings> {

    var settings = Settings()

    override fun getState() = settings

    override fun loadState(other: Settings) {
        settings = other.copy()
    }

    companion object {

        val INSTANCE: SettingsComponent =
            ServiceManager.getService(SettingsComponent::class.java)

    }

}