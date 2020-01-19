package gdscript.annotator

import gdscript.BaseTest
import uitlities.openScript

class InvalidImportSeparatorAnnotatorTest : BaseTest() {

    fun `test error on invalid separator`() {
        environment.openScript("""preload("res://dir\test.gd")""")
        val error = environment.doHighlighting().first()
        assertEquals(error.text, "\"res://dir\\test.gd\"")
        assertEquals(error.description, "Invalid separator")
    }

}