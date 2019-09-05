package gdscript.commenter

import com.intellij.openapi.actionSystem.IdeActions.ACTION_COMMENT_LINE
import com.intellij.testFramework.PlatformTestUtil.invokeNamedAction
import gdscript.GdFileType
import gdscript.GdTestBase

class GdCommenterTest : GdTestBase() {

    fun `test comment`() =
        assertCodeChangesAfterCommentAction("${CARET_MARKER}var x", "#var x")

    fun `test undo comment`() =
        assertCodeChangesAfterCommentAction("$CARET_MARKER#var x", "var x")

    private fun assertCodeChangesAfterCommentAction(before: String, after: String) {
        myFixture.configureByText(GdFileType, before)
        invokeNamedAction(ACTION_COMMENT_LINE)
        myFixture.checkResult(after)
    }

}