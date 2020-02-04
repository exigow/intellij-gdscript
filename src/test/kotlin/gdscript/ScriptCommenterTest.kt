package gdscript

import BaseTest
import utils.doCommentLineAction
import utils.openScript

class ScriptCommenterTest : BaseTest() {

    fun `test comment`() {
        environment.openScript("const M<caret>AX = 100")
        environment.doCommentLineAction()
        environment.checkResult("#const MAX = 100")
    }

    fun `test uncomment`() {
        environment.openScript("#size += 1<caret>")
        environment.doCommentLineAction()
        environment.checkResult("size += 1")
    }

    fun `test override existing comment with new comment`() {
        environment.openScript("var size#: Vector2<caret>")
        environment.doCommentLineAction()
        environment.checkResult("#var size#: Vector2")
    }

}