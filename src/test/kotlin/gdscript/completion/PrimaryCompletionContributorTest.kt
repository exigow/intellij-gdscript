package gdscript.completion

import gdscript.BaseTest
import uitlities.lookupTexts
import uitlities.openCode

class PrimaryCompletionContributorTest : BaseTest() {

    fun `test keyword as value`() {
        environment.openCode("x = <caret>")
        assertTrue("self" in environment.lookupTexts())
        assertTrue("null" in environment.lookupTexts())
        assertTrue("false" in environment.lookupTexts())
    }

    fun `test function as statement`() {
        environment.openCode("pr<caret>")
        assertTrue("print" in environment.lookupTexts())
    }

    fun `test function in var statement`() {
        environment.openCode("var x = si<caret>")
        assertTrue("sin" in environment.lookupTexts())
    }

    fun `test function in dictionary`() {
        environment.openCode("dict = {A = 1, B = si<caret>}")
        assertTrue("sin" in environment.lookupTexts())
    }

    fun `test Vector2 constructor`() {
        environment.openCode("position = Vec<caret>")
        assertTrue("Vector2" in environment.lookupTexts())
    }

    fun `test primitive float constructor`() {
        environment.openCode("x = flo<caret>")
        assertTrue("float" in environment.lookupTexts())
    }

    fun `test values are not present after DOT operator`() {
        environment.openCode("vector.fa<caret>")
        assertFalse("false" in environment.lookupTexts())
    }

    fun `test do not complete inside string`() {
        environment.openCode("""x = "flo<caret>" """)
        assertFalse("float" in environment.lookupTexts())
    }

    fun `test variable completion in argument default value`() {
        environment.openCode("func f(arg=nul<caret>):")
        assertEmpty(environment.lookupTexts())
    }

    fun `test typing numbers doesn't invokes constants with numbers in names`() {
        environment.openCode("x = 1<caret>")
        assertEmpty(environment.lookupTexts())
    }

}
