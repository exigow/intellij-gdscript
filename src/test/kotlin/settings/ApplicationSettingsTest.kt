package settings

import BaseTest

class ApplicationSettingsTest : BaseTest() {

    fun `test default version`() {
        val settings = ApplicationSettings()
        assertEquals("3.2", settings.versionId)
    }

    fun `test version load state`() {
        val tested = ApplicationSettings("0.0")
        tested.loadState(ApplicationSettings("1.0"))
        assertEquals("1.0", tested.versionId)
    }

}