package gdscript.commenter

import gdscript.BaseTest
import uitlities.doCommentAction
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
        environment.doCommentAction()
        environment.checkResult(after)
    }

}