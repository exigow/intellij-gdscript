package gdscript.completion

import gdscript.BaseTest
import uitlities.*

class KeywordCompletionContributorTest : BaseTest() {

    fun `test complete "var" keyword after new line"`() {
        environment.openCode("\nva<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "var")
    }

    fun `test complete "static" keyword after new line`() {
        environment.openCode("\nsta<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "static")
    }

}
