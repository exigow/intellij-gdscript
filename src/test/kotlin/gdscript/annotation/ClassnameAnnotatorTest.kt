package gdscript.annotation

import BaseTest
import utils.assertHasHighlight
import utils.openScript

class ClassnameAnnotatorTest : BaseTest() {

    fun `test Vector2`() {
        environment.openScript("position = Vector2(0, 0)")
        assertHasHighlight(environment.doHighlighting(), "Vector2", "GDSCRIPT_CLASS_NAME")
    }

    fun `test OS similar to constant`() {
        environment.openScript("OS.center_window()")
        assertHasHighlight(environment.doHighlighting(), "OS", "GDSCRIPT_CLASS_NAME")
    }

    fun `test similar name is not matched partially`() {
        environment.openScript("x = MyVector3()")
        assertEmpty(environment.doHighlighting())
    }

}
