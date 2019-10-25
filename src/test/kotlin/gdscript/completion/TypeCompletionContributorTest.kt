package gdscript.completion

import gdscript.BaseTest
import uitlities.openCode
import uitlities.assertContains
import uitlities.lookups

class TypeCompletionContributorTest : BaseTest() {

    fun `test accept lower-case classes`() {
        environment.openCode("var p: vec<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "Vector2")
    }

    fun `test accept upper-case primitives`() {
        environment.openCode("var p: Flo<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "float")
    }

    fun `test "as"`() {
        environment.openCode("p as Vec<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "Vector2")
    }

    fun `test "is"`() {
        environment.openCode("p is Vec<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "Vector2")
    }

    fun `test "extends"`() {
        environment.openCode("extends Vec<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "Vector2")
    }

    fun `test "func" with argument`() {
        environment.openCode("func draw_quad(position: <caret>):")
        environment.completeBasic()
        assertContains(environment.lookups(), "Vector2")
    }

    fun `test "func" with colon after caret`() {
        environment.openCode("func get_name() -> <caret>:")
        environment.completeBasic()
        assertContains(environment.lookups(), "Vector2")
    }

}
