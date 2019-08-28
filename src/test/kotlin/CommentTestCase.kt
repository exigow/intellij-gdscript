import com.intellij.codeInsight.completion.CompletionType
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.GDScriptFileType

class CommentTestCase : BasePlatformTestCase() {

    fun `test completion keyword var`() =
        assertCompletionContains("va<caret>", "var")

    fun `test completion keyword const`() =
        assertCompletionContains("co<caret>", "const")

    private fun assertCompletionContains(code: String, expectedLookup: String) {
        myFixture.configureByText(GDScriptFileType, code)
        myFixture.complete(CompletionType.BASIC, 1)
        val lookups = myFixture.lookupElementStrings!!
        assertTrue(lookups.contains(expectedLookup));
    }

}