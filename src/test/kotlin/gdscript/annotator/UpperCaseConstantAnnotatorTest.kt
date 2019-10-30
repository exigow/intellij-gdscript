package gdscript.annotator

import gdscript.BaseTest
import uitlities.openCode
import uitlities.checkInfoHighlighting

class UpperCaseConstantAnnotatorTest : BaseTest() {

    fun `test NUMBER constant`() {
        environment.openCode("const ${info("NUMBER")} = 100")
        environment.checkInfoHighlighting()
    }

    fun `test SOME_VALUE constant`() {
        environment.openCode("const ${info("SOME_VALUE")} = 0")
        environment.checkInfoHighlighting()
    }

}