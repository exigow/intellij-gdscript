package gdscript.annotator

import gdscript.BaseTest
import uitlities.openCode
import uitlities.checkInfoHighlighting

class InstanceFieldAnnotatorTest : BaseTest() {

    fun `test property`() {
        environment.openCode("dir.${info("x")}")
        environment.checkInfoHighlighting()
    }

    fun `test property of property`() {
        environment.openCode("some.${info("inner")}.${info("inner2")}")
        environment.checkInfoHighlighting()
    }
}