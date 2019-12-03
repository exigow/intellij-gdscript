package gdscript.colorSettingsPage

import junit.framework.TestCase

class ColorSettingsPageTest : TestCase() {

    fun `test descriptors map has only required annotation keys`() {
        val descriptors = ColorSettingsPage().additionalHighlightingTagToDescriptorMap
        val keys: List<String> = descriptors.map { it.key }
        assertTrue(ColorTextAttributeKey.STATIC_METHOD.key.externalName in keys)
        assertFalse(ColorTextAttributeKey.KEYWORD.key.externalName in keys)
    }

}