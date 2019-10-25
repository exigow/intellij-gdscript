package gdscript.commenter

import com.intellij.openapi.actionSystem.IdeActions.ACTION_COMMENT_LINE
import com.intellij.testFramework.PlatformTestUtil.invokeNamedAction
import gdscript.BaseTest
import uitlities.openCode

class ScriptCommenterTest : BaseTest() {

    fun `test comment`() =
        assertCommentAction("const M<caret>AX = 100", "#const MAX = 100")

    fun `test uncomment`() =
        assertCommentAction("#size += 1<caret>", "size += 1")

    fun `test override existing comment with new comment`() =
        assertCommentAction("var size#: Vector2<caret>", "#var size#: Vector2")

    private fun assertCommentAction(before: String, after: String) {
        environment.openCode(before)
        invokeNamedAction(ACTION_COMMENT_LINE)
        environment.checkResult(after)
    }

}