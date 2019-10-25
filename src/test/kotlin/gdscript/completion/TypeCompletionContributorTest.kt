package gdscript.completion

import gdscript.BaseTest
import uitlities.openCode
import uitlities.assertContains
import uitlities.lookups

class TypeCompletionContributorTest : BaseTest() {

    fun `test accept lower-case classes`() =
        assertLookupsContains("var p: vec<caret>", "Vector2")

    fun `test accept upper-case primitives`() =
        assertLookupsContains("var p: Flo<caret>", "float")

    fun `test "as"`() =
        assertLookupsContains("p as Vec<caret>", "Vector2")

    fun `test "is"`() =
        assertLookupsContains("p is Vec<caret>", "Vector2")

    fun `test "extends"`() =
        assertLookupsContains("extends Vec<caret>", "Vector2")

    fun `test "func" with argument`() =
        assertLookupsContains("func draw_quad(position: <caret>):", "Vector2")

    fun `test "func" with colon after caret`() =
        assertLookupsContains("func get_name() -> <caret>:", "Vector2")

    private fun assertLookupsContains(code: String, expected: String) {
        environment.openCode(code)
        environment.completeBasic()
        assertContains(environment.lookups(), expected)
    }

}
