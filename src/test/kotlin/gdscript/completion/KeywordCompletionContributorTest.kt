package gdscript.completion

import gdscript.BaseTest
import uitlities.lookupTexts
import uitlities.openCode

class KeywordCompletionContributorTest : BaseTest() {

    fun `test newline var`() {
        environment.openCode("\nva<caret>")
        assertTrue("var" in environment.lookupTexts())
    }

    fun `test newline const`() {
        environment.openCode("\ncon<caret>")
        assertTrue("const" in environment.lookupTexts())
    }

    fun `test newline static`() {
        environment.openCode("\nsta<caret>")
        assertTrue("static" in environment.lookupTexts())
    }

    fun `test newline class_name`() {
        environment.openCode("\nclas<caret>")
        assertTrue("class_name" in environment.lookupTexts())
    }

}
