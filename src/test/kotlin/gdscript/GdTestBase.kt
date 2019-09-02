package gdscript

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction
import com.intellij.testFramework.fixtures.BasePlatformTestCase

abstract class GdTestBase : BasePlatformTestCase() {

    fun assertCodeCompletionContains(code: String, expectedLookups: List<String>) {
        myFixture.configureByText(GdFileType, code)
        myFixture.complete(CompletionType.BASIC, 1)
        val lookups = myFixture.lookupElementStrings.orEmpty()
        for (testedLookup in expectedLookups) {
            if (!lookups.contains(testedLookup))
                fail("Missing completion $testedLookup in $lookups")
        }
    }

    fun assertCodeChangesAfterAction(before: String, after: String) {
        myFixture.configureByText(GdFileType, before)
        CommentByLineCommentAction().actionPerformedImpl(project, myFixture.editor)
        myFixture.checkResult(after)
    }

    companion object {

        const val CARET_MARKER = "<caret>"

    }

}