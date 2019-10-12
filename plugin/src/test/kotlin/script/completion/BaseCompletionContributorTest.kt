package script.completion

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import script.ScriptFileType

abstract class BaseCompletionContributorTest : BasePlatformTestCase() {

    fun assertLookupsContains(code: String, expectedLookup: String) {
        configureEditor(code)
        val lookups = getEditorLookups()
        if (!lookups.contains<String>(expectedLookup))
            fail("Expected element `$expectedLookup` not found, list: $lookups")
    }

    fun assertLookupsNotContains(code: String, unwantedLookup: String) {
        configureEditor(code)
        val list = getEditorLookups()
        if (list.contains<String>(unwantedLookup))
            fail("Unwanted element `$unwantedLookup` found in list: $list")
    }

    private fun configureEditor(code: String) {
        myFixture.configureByText(ScriptFileType, code)
        myFixture.completeBasic()
    }

    private fun getEditorLookups() = myFixture.lookupElementStrings.orEmpty()

}