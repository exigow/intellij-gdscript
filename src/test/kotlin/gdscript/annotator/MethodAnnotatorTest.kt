package gdscript.annotator

import gdscript.BaseTest
import uitlities.highlights
import uitlities.openScript

class MethodAnnotatorTest : BaseTest() {

    fun `test highlight function name`() {
        environment.openScript("func _init():")
        assertContainsElements(environment.highlights(), "_init")
    }

    fun `test highlight static function name`() {
        environment.openScript("static func add():")
        assertContainsElements(environment.highlights(), "add")
    }

}