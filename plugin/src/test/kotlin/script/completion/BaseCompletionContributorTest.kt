package script.completion

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import script.ScriptFileType

abstract class BaseCompletionContributorTest : BasePlatformTestCase() {

    fun assertCompletionEquals(code: String, expectedLookup: String) {
        myFixture.configureByText(ScriptFileType, code)
        myFixture.completeBasic()
        assertContains(myFixture.lookupElementStrings.orEmpty(), expectedLookup)
    }

    private fun assertContains(list: Iterable<String>, expected: String) {
        val found = list.findLast { it == expected }
        if (found == null)
            fail("Expected element `$expected` not found, list: $list")
    }

}