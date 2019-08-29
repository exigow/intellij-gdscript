package gdscript

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.GdLanguageFileType

abstract class GdBaseTest : BasePlatformTestCase() {

    fun assertCompletionContains(code: String, expectedLookup: String) {
        myFixture.configureByText(GdLanguageFileType, code)
        myFixture.complete(CompletionType.BASIC, 1)
        val lookups = myFixture.lookupElementStrings!!
        assertTrue(lookups.contains(expectedLookup));
    }

    fun assertCodeAction(before: String, after: String) {
        myFixture.configureByText(GdLanguageFileType, before)
        CommentByLineCommentAction().actionPerformedImpl(project, myFixture.editor);
        myFixture.checkResult(after);
    }

}