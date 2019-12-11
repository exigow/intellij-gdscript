package gdscript.colorSettingsPage

import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import com.intellij.testFramework.UsefulTestCase.assertDoesntContain
import junit.framework.TestCase

class ColorSettingsPageTest : TestCase() {

    fun `test descriptors map has only required annotation keys`() {
        val descriptors = ColorSettingsPage().additionalHighlightingTagToDescriptorMap
        val keys: List<String> = descriptors.map { it.key }
        assertContainsElements(keys, ColorTextAttributeKey.STATIC_METHOD.key.externalName)
        assertDoesntContain(keys, ColorTextAttributeKey.KEYWORD.key.externalName)
    }

}