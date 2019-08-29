package gdscript

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction
import com.intellij.testFramework.fixtures.BasePlatformTestCase

abstract class BaseTest : BasePlatformTestCase() {

    fun assertCodeCompletionContains(code: String, expectedLookups: List<String>) {
        myFixture.configureByText(LanguageFileType, code)
        myFixture.complete(CompletionType.BASIC, 1)
        val lookups = myFixture.lookupElementStrings!!
        for (testedLookup in expectedLookups)
            assertTrue(lookups.contains(testedLookup));
    }

    fun assertCodeChangesAfterAction(before: String, after: String) {
        myFixture.configureByText(LanguageFileType, before)
        CommentByLineCommentAction().actionPerformedImpl(project, myFixture.editor);
        myFixture.checkResult(after);
    }

}