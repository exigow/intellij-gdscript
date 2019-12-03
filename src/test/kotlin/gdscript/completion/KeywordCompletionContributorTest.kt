package gdscript.completion

import gdscript.BaseTest
import uitlities.lookupTexts
import uitlities.openCode

class KeywordCompletionContributorTest : BaseTest() {

    fun `test complete "var" keyword after new line"`() {
        environment.openCode("\nva<caret>")
        assertTrue("var" in environment.lookupTexts())
    }

    fun `test complete "static" keyword after new line`() {
        environment.openCode("\nsta<caret>")
        assertTrue("static" in environment.lookupTexts())
    }

}
