package gdscript.lang.commenter

import gdscript.BaseTest
import uitlities.doCommentAction
import uitlities.openResource

class ResourceCommenterTest : BaseTest() {

    fun `test comment then uncomment`() {
        environment.openResource("test<caret>")
        environment.doCommentAction()
        environment.checkResult(";test<caret>")
        environment.doCommentAction()
        environment.checkResult("test<caret>")
    }

}