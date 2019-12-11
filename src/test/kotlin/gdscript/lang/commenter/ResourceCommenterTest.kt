package gdscript.lang.commenter

import gdscript.BaseTest
import uitlities.doCommentLineAction
import uitlities.openResource

class ResourceCommenterTest : BaseTest() {

    fun `test comment then uncomment`() {
        environment.openResource("test<caret>")
        environment.doCommentLineAction()
        environment.checkResult(";test<caret>")
        environment.doCommentLineAction()
        environment.checkResult("test<caret>")
    }

}