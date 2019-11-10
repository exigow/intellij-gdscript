package gdscript.lang.commenter

import gdscript.BaseTest
import uitlities.doCommentAction
import uitlities.openCode

class ScriptCommenterTest : BaseTest() {

    fun `test comment`() {
        environment.openCode("const M<caret>AX = 100")
        environment.doCommentAction()
        environment.checkResult("#const MAX = 100")
    }

    fun `test uncomment`() {
        environment.openCode("#size += 1<caret>")
        environment.doCommentAction()
        environment.checkResult("size += 1")
    }

    fun `test override existing comment with new comment`() {
        environment.openCode("var size#: Vector2<caret>")
        environment.doCommentAction()
        environment.checkResult("#var size#: Vector2")
    }

}