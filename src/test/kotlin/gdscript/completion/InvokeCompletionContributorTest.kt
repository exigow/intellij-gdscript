package gdscript.completion

import gdscript.BaseTest
import uitlities.lookupTexts
import uitlities.openCode

class InvokeCompletionContributorTest : BaseTest() {

    fun `test edit existing function`() {
        environment.openCode("si<caret>(1)")
        assertTrue("sin" in environment.lookupTexts())
    }

    fun `test edit existing range function in for statement`() {
        environment.openCode("for i in rang<caret>(1, 2):")
        assertTrue("range" in environment.lookupTexts())
    }

    fun `test edit existing constructor`() {
        environment.openCode("Vec<caret>(1, 2)")
        assertTrue("Vector2" in environment.lookupTexts())
    }

    fun `test edit existing constructor is case-insensitive`() {
        environment.openCode("vec<caret>(1, 2)")
        assertTrue("Vector2" in environment.lookupTexts())
    }

}
