package gdscript

import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import com.intellij.testFramework.UsefulTestCase.assertDoesntContain
import common.Colors
import junit.framework.TestCase

class ScriptColorSettingsPageTest : TestCase() {

    fun `test descriptors map has only required annotation keys`() {
        val descriptors = ScriptColorSettingsPage().additionalHighlightingTagToDescriptorMap
        val keys: List<String> = descriptors.map { it.key }
        assertContainsElements(keys, Colors.STATIC_METHOD.key.externalName)
        assertDoesntContain(keys, Colors.KEYWORD.key.externalName)
    }

}