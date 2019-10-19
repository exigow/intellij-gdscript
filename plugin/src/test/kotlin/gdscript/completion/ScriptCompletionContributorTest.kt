package gdscript.completion

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.file.ScriptType
import uitlities.assertContains
import uitlities.assertNotContains

class ScriptCompletionContributorTest : BasePlatformTestCase() {

    fun `test variable definition Vector2 type`() =
        assertLookupsContains("var position: Vec<caret>", "Vector2")

    fun `test class type is case-sensitive`() =
        assertLookupsNotContains("var position: vec<caret>", "Vector2")

    fun `test extends with Node class`() =
        assertLookupsContains("extends No<caret>", "Node")

    fun `test function return class type`() =
        assertLookupsContains("func get_name() -> <caret>:", "String")

    fun `test function return class type with missing colon`() =
        assertLookupsContains("func get_name() -> <caret>", "String")

    fun `test function argument type`() =
        assertLookupsContains("func draw_quad(geometry: <caret>):", "ImmediateGeometry")

    fun `test self completion`() =
        assertLookupsContains("x = se<caret>", "self")

    fun `test true completion`() =
        assertLookupsContains("x = tr<caret>", "true")

    fun `test primitive type is case-sensitive`() =
        assertLookupsNotContains("var hp: Flo<caret>", "float")

    fun `test extends Vector2 class`() =
        assertLookupsContains("extends Vec<caret>", "Vector2")

    fun `test function as statement`() =
        assertLookupsContains("pr<caret>", "print")

    fun `test edit existing function`() =
        assertLookupsContains("x = si<caret>()", "sin")

    fun `test function in var statement`() =
        assertLookupsContains("var x = si<caret>", "sin")

    fun `test function in dictionary`() =
        assertLookupsContains("dict = {A = 1, B = si<caret>}", "sin")

    fun `test range function`() =
        assertLookupsContains("for i in rang<caret>(3):", "range")

    fun `test Vector2 constructor`() =
        assertLookupsContains("position = Vec<caret>", "Vector2")

    fun `test primitive float constructor`() =
        assertLookupsContains("x = flo<caret>", "float")

    fun `test edit existing constructor`() =
        assertLookupsContains("position = Vec<caret>()", "Vector2")

    fun `test function is case-sensitive`() =
        assertLookupsNotContains("x = Si<caret>()", "sin")

    fun `test constructor call is case-sensitive`() =
        assertLookupsNotContains("position = vec<caret>()", "Vector2")

    fun `test values are not present after DOT operator`() {
        assertLookupsNotContains("vector.fa<caret>", "false")
        assertLookupsNotContains("Input.deg<caret>", "deg2rad")
        assertLookupsNotContains("Camera.Vec<caret>", "Vector2")
    }

    private fun assertLookupsContains(code: String, expected: String) {
        configureEditor(code)
        assertContains(myFixture.lookupElementStrings, expected)
    }

    private fun assertLookupsNotContains(code: String, unwanted: String) {
        configureEditor(code)
        assertNotContains(myFixture.lookupElementStrings, unwanted)
    }

    private fun configureEditor(code: String) {
        myFixture.configureByText(ScriptType, code)
        myFixture.completeBasic()
    }

}
