package gdscript.completion

import com.intellij.codeInsight.completion.CompletionType
import gdscript.GdFileType
import gdscript.GdTestBase

class GdKeywordCompletionContributorTest : GdTestBase() {

    fun `test keyword var`() =
        assertCodeCompletionContains("va${CARET}", listOf("var"))

    fun `test keyword const`() =
        assertCodeCompletionContains("co${CARET}", listOf("const"))

    fun assertCodeCompletionContains(code: String, expectedLookups: List<String>) {
        myFixture.configureByText(GdFileType, code)
        myFixture.complete(CompletionType.BASIC, 1)
        val lookups = myFixture.lookupElementStrings.orEmpty()
        for (testedLookup in expectedLookups) {
            if (!lookups.contains(testedLookup))
                fail("Missing completion $testedLookup in $lookups")
        }
    }

}