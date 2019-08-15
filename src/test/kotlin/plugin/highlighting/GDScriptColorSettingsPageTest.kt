package plugin.highlighting

import org.junit.Assert.assertEquals
import org.junit.Test

class GDScriptColorSettingsPageTest {

    @Test
    fun `attribute names should be humanized from code`() {
        val attributeNames = GDScriptColorSettingsPage().attributeDescriptors
            .map { it.displayName }
        assertEquals("Class Name", attributeNames[4])
        assertEquals("Keyword", attributeNames[0])
    }

}