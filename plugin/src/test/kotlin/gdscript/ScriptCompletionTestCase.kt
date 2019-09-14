package gdscript

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class ScriptCompletionTestCase : BasePlatformTestCase() {

    fun `test variable keyword`() =
        assertCompletion("va$CARET", "var")

    fun `test constant keyword`() =
        assertCompletion("con$CARET", "const")

    fun `test class keyword`() =
        assertCompletion("cl$CARET", "class")

    fun `test class_name keyword`() =
        assertCompletion("cl$CARET", "class_name")

    fun `test variable type`() =
        assertCompletion("var position: Vec$CARET", "Vector2")

    fun `test extends type`() =
        assertCompletion("extends No$CARET", "Node")

    fun `test function type`() =
        assertCompletion("func get_name() -> $CARET", "String")

    fun `test function argument type`() =
        assertCompletion("func draw_quad(geometry: $CARET):", "ImmediateGeometry")

    fun `test language level function`() =
        assertCompletion("si$CARET", "sin")

    fun `test constant field`() =
        assertCompletion("AnimatedTexture.MAX_$CARET", "MAX_FRAMES")

    fun `test method`() =
        assertCompletion("sprite.is_$CARET()", "is_pixel_opaque")

    fun `test field setter`() =
        assertCompletion("compressor.set_back$CARET()", "set_background")

    fun `test field getter`() =
        assertCompletion("compressor.get_back$CARET()", "get_background")

    private fun assertCompletion(code: String, expectedLookup: String) {
        myFixture.configureByText(ScriptFileType, code)
        myFixture.completeBasic()
        assertTrue(myFixture.lookupElementStrings!!.contains(expectedLookup))
    }

    companion object {
        const val CARET = "<caret>"
    }

}