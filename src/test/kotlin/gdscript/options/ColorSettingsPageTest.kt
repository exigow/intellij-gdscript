package gdscript.options

import junit.framework.TestCase
import uitlities.assertContains
import uitlities.assertNotContains

class ColorSettingsPageTest : TestCase() {

    fun `test descriptors map has only required annotation keys to avoid bugs`() {
        val descriptors = ColorSettingsPage().additionalHighlightingTagToDescriptorMap
        val keys: List<String> = descriptors.map { it.key }
        assertContains(keys, ColorTextAttributeKey.STATIC_METHOD.key.externalName)
        assertNotContains(keys, ColorTextAttributeKey.KEYWORD.key.externalName)
    }

}