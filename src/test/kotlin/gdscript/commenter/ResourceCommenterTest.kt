package gdscript.commenter

import com.intellij.openapi.actionSystem.IdeActions.ACTION_COMMENT_LINE
import com.intellij.testFramework.PlatformTestUtil.invokeNamedAction
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.file.ResourceType

class ResourceCommenterTest : BasePlatformTestCase() {

    fun `test comment then uncomment`() {
        myFixture.configureByText(ResourceType, "test<caret>")
        invokeNamedAction(ACTION_COMMENT_LINE)
        myFixture.checkResult(";test<caret>")
        invokeNamedAction(ACTION_COMMENT_LINE)
        myFixture.checkResult("test<caret>")
    }

}