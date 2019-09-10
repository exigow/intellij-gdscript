package gdscript

import com.intellij.openapi.actionSystem.IdeActions.ACTION_COMMENT_LINE
import com.intellij.testFramework.PlatformTestUtil.invokeNamedAction
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class CommentingTestCase : BasePlatformTestCase() {

    fun `test comment`() =
        assertCodeChangesAfterCommentAction("const M<caret>AX = 100", "#const MAX = 100")

    fun `test uncomment`() =
        assertCodeChangesAfterCommentAction("#size += 1<caret>", "size += 1")

    fun `test override existing comment with new comment`() =
        assertCodeChangesAfterCommentAction("var size#: Vector2<caret>", "#var size#: Vector2")

    private fun assertCodeChangesAfterCommentAction(before: String, after: String) {
        myFixture.configureByText(GdFileType, before)
        invokeNamedAction(ACTION_COMMENT_LINE)
        myFixture.checkResult(after)
    }

}