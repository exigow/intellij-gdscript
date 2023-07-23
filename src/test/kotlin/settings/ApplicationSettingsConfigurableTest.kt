package settings

import BaseTest
import com.intellij.openapi.components.ServiceManager

class ApplicationSettingsConfigurableTest : BaseTest() {

    fun `test GUI modifies settings`() {
        val gui = ApplicationSettingsConfigurable()
        assertFalse(gui.isModified)
        ServiceManager.getService(ApplicationSettings::class.java).versionId = "1.2.3"
        assertTrue(gui.isModified)
    }

}
