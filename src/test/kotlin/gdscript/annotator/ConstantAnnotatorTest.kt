package gdscript.annotator

import gdscript.BaseTest
import uitlities.highlights
import uitlities.openScript

class ConstantAnnotatorTest : BaseTest() {

    fun `test simple name`() {
        environment.openScript("const NUMBER = 42")
        assertContainsElements(environment.highlights(), "NUMBER")
    }

    fun `test name with underscore`() {
        environment.openScript("const MAX_HEALTH = 100")
        assertContainsElements(environment.highlights(), "MAX_HEALTH")
    }

    fun `test name with number`() {
        environment.openScript("const PLAYER_2 = 0")
        assertContainsElements(environment.highlights(), "PLAYER_2")
    }

    fun `test don't highlight single underscore like wildcard from match statement`() {
        environment.openScript("_:")
        assertEmpty(environment.highlights())
    }

}