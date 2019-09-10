package gdscript.commenter

import com.intellij.openapi.actionSystem.IdeActions.ACTION_COMMENT_LINE
import com.intellij.testFramework.PlatformTestUtil.invokeNamedAction
import gdscript.GdFileType
import gdscript.GdTestBase

class GdCommenterTest : GdTestBase() {

    fun `test comment`() =
        assertCodeChangesAfterCommentAction("const M${CARET}AX = 100", "#const MAX = 100")

    fun `test uncomment`() =
        assertCodeChangesAfterCommentAction("#size += 1${CARET}", "size += 1")

    fun `test override existing comment with new comment`() =
        assertCodeChangesAfterCommentAction("var size#: Vector2${CARET}", "#var size#: Vector2")

    private fun assertCodeChangesAfterCommentAction(before: String, after: String) {
        myFixture.configureByText(GdFileType, before)
        invokeNamedAction(ACTION_COMMENT_LINE)
        myFixture.checkResult(after)
    }

}