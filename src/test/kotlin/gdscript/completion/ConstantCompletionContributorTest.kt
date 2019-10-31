package gdscript.completion

import gdscript.BaseTest
import uitlities.*

class ConstantCompletionContributorTest : BaseTest() {

    fun `test constant field immediately after typing dot`() {
        environment.openCode("one = Vector2.<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "ONE")
    }

}
