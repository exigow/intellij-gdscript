package gdscript.annotator

import gdscript.BaseTest
import uitlities.openCode
import uitlities.checkInfoHighlighting

class EntryKeyAnnotatorTest : BaseTest() {

    fun `test dictionary entry key highlighting`() {
        environment.openCode("dict = {${info("key")} = value}")
        environment.checkInfoHighlighting()
    }

    fun `test dictionary entry string key highlighting`() {
        environment.openCode("dict = {${info("\"key\"")} = value}")
        environment.checkInfoHighlighting()
    }

}