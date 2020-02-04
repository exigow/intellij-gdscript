package gdscript.annotation

import BaseTest
import utils.highlights
import utils.openScript

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