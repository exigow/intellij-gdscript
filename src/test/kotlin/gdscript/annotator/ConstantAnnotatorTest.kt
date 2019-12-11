package gdscript.annotator

import gdscript.BaseTest
import uitlities.*

class ConstantAnnotatorTest : BaseTest() {

    fun `test highlight constant name`() {
        environment.openScript("const NUMBER = 42")
        assertContainsElements(environment.highlights(), "NUMBER")
    }

    fun `test highlight constant name with underscore`() {
        environment.openScript("const MAX_HEALTH = 100")
        assertContainsElements(environment.highlights(), "MAX_HEALTH")
    }

    fun `test don't highlight single underscore`() {
        environment.openScript("_:")
        assertEmpty(environment.highlights())
    }

}