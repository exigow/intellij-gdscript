package settings

import BaseTest
import com.intellij.openapi.components.ServiceManager

class ApplicationSettingsConfigurableTest : BaseTest() {

    fun `test GUI detects settings component modification`() {
        val gui = ApplicationSettingsConfigurable()
        assertFalse(gui.isModified)
        ServiceManager.getService(ApplicationSettings::class.java).lspEnabled = true
        assertTrue(gui.isModified)
    }

}