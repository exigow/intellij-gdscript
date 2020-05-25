package settings

import BaseTest

class ApplicationSettingsTest : BaseTest() {

    fun `test is LSP disabled by default`() {
        val settings = ApplicationSettings()
        assertFalse(settings.lspEnabled)
    }

    fun `test loads state from other settings`() {
        val tested = ApplicationSettings()
        val other = ApplicationSettings(true)
        tested.loadState(other)
        assertTrue(tested.lspEnabled)
    }

}