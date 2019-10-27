package gdscript.annotator

import gdscript.BaseTest
import uitlities.openCode
import uitlities.checkInfoHighlighting

class MethodAnnotatorTest : BaseTest() {

    fun `test function declaration`() {
        environment.openCode("func ${info("_init")}():")
        environment.checkInfoHighlighting()
    }

    fun `test static function declaration`() {
        environment.openCode("static func ${info("add")}():")
        environment.checkInfoHighlighting()
    }

}