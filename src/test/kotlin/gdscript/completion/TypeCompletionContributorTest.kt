package gdscript.completion

import gdscript.BaseTest
import uitlities.openCode
import uitlities.assertContains

class TypeCompletionContributorTest : BaseTest() {

    fun `test var`() {
        assertLookupsContains("var p: Vec<caret>", "Vector2")
        assertLookupsContains("var p: vec<caret>", "Vector2")
        assertLookupsContains("var p: Flo<caret>", "float")
        assertLookupsContains("var p: flo<caret>", "float")
    }

    fun `test as operator`() =
        assertLookupsContains("platform as Kinem<caret>", "KinematicBody2D")

    fun `test is operator`() =
        assertLookupsContains("image is Spri<caret>", "Sprite")

    fun `test extends object`() =
        assertLookupsContains("extends Vec<caret>", "Vector2")

    fun `test function argument`() =
        assertLookupsContains("func draw_quad(geometry: <caret>):", "ImmediateGeometry")

    fun `test function with colon`() =
        assertLookupsContains("func get_name() -> <caret>:", "String")

    private fun assertLookupsContains(code: String, expected: String) {
        environment.openCode(code)
        environment.completeBasic()
        assertContains(environment.lookupElementStrings, expected)
    }

}
