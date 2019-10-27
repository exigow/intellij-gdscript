package gdscript.annotator

import gdscript.BaseTest
import uitlities.openCode
import uitlities.checkInfoHighlighting

class KeywordAnnotatorTest : BaseTest() {

    fun `test deg2rad function`() {
        environment.openCode("radians = ${info("deg2rad")}(147)")
        environment.checkInfoHighlighting()
    }

    fun `test cosh function`() {
        environment.openCode("x = ${info("cosh")}(0.13)")
        environment.checkInfoHighlighting()
    }

}