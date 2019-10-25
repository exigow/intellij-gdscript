package gdscript.commenter

import com.intellij.openapi.actionSystem.IdeActions.ACTION_COMMENT_LINE
import com.intellij.testFramework.PlatformTestUtil.invokeNamedAction
import gdscript.BaseTest
import uitlities.openResource

class ResourceCommenterTest : BaseTest() {

    fun `test comment then uncomment`() {
        environment.openResource("test<caret>")
        invokeNamedAction(ACTION_COMMENT_LINE)
        environment.checkResult(";test<caret>")
        invokeNamedAction(ACTION_COMMENT_LINE)
        environment.checkResult("test<caret>")
    }

}