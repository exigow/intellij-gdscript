package gdscript

import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import junit.framework.TestCase

class ScriptColorSettingsPageTest : TestCase() {

    fun `test setting has correctly humanized names from enums`() {
        val descriptors = ScriptColorSettingsPage().attributeDescriptors
        val displayNames = descriptors.map { it.displayName }
        assertContainsElements(displayNames, "Number")
        assertContainsElements(displayNames, "Instance Method")
    }

}