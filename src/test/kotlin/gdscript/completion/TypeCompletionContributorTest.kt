package gdscript.completion

import gdscript.BaseTest
import uitlities.lookupTexts
import uitlities.openCode

class TypeCompletionContributorTest : BaseTest() {

    fun `test accept lower-case classes`() {
        environment.openCode("var p: vec<caret>")
        assertTrue("Vector2" in environment.lookupTexts())
    }

    fun `test accept upper-case primitives`() {
        environment.openCode("var p: Flo<caret>")
        assertTrue("float" in environment.lookupTexts())
    }

    fun `test "as"`() {
        environment.openCode("p as Vec<caret>")
        assertTrue("Vector2" in environment.lookupTexts())
    }

    fun `test "is"`() {
        environment.openCode("p is Vec<caret>")
        assertTrue("Vector2" in environment.lookupTexts())
    }

    fun `test "extends"`() {
        environment.openCode("extends Vec<caret>")
        assertTrue("Vector2" in environment.lookupTexts())
    }

    fun `test "func" with argument`() {
        environment.openCode("func draw_quad(position: <caret>):")
        assertTrue("Vector2" in environment.lookupTexts())
    }

    fun `test "func" with colon after caret`() {
        environment.openCode("func get_name() -> <caret>:")
        assertTrue("Vector2" in environment.lookupTexts())
    }

}
