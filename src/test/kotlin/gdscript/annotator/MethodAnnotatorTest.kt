package gdscript.annotator

import gdscript.BaseTest
import uitlities.highlightedTexts
import uitlities.openCode

class MethodAnnotatorTest : BaseTest() {

    fun `test function declaration`() {
        environment.openCode("func _init():")
        assertTrue("_init" in environment.highlightedTexts())
    }

    fun `test static function declaration`() {
        environment.openCode("static func add():")
        assertTrue("add" in environment.highlightedTexts())
    }

}