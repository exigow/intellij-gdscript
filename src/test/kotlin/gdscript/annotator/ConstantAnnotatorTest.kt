package gdscript.annotator

import gdscript.BaseTest
import uitlities.*

class ConstantAnnotatorTest : BaseTest() {

    fun `test constant`() {
        environment.openCode("const NUMBER = 42")
        assertTrue("NUMBER" in environment.highlightedTexts())
    }

    fun `test constant with underscore`() {
        environment.openCode("const MAX_HEALTH = 100")
        assertTrue("MAX_HEALTH" in environment.highlightedTexts())
    }

    fun `test single underscore like wildcard pattern is not constant`() {
        environment.openCode("_:")
        assertEmpty(environment.highlightedTexts())
    }

}