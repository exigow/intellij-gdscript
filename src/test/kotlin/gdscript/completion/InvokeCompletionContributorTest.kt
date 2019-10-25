package gdscript.completion

import gdscript.BaseTest
import uitlities.openCode
import uitlities.assertContains
import uitlities.assertNotContains
import uitlities.lookups

class InvokeCompletionContributorTest : BaseTest() {

    fun `test "self" keyword`() =
        assertLookupsContains("x = se<caret>", "self")

    fun `test "true" keyword`() =
        assertLookupsContains("x = tr<caret>", "true")

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
        environment.openCode(code)
        environment.completeBasic()
        assertContains(environment.lookups(), expected)
    }

    private fun assertLookupsNotContains(code: String, unwanted: String) {
        environment.openCode(code)
        environment.completeBasic()
        assertNotContains(environment.lookups(), unwanted)
    }

}
