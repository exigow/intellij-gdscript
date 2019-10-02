package script

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.testFramework.fixtures.CodeInsightTestFixture

class ScriptCompletionTestCase : BasePlatformTestCase() {

    fun `test variable keyword`() =
        assertCompletion("va<caret>", "var")

    fun `test constant keyword`() =
        assertCompletion("con<caret>", "const")

    fun `test class keyword`() =
        assertCompletion("cl<caret>", "class")

    fun `test class_name keyword`() =
        assertCompletion("cl<caret>", "class_name")

    fun `test variable type`() =
        assertCompletion("var position: Vec<caret>", "Vector2")

    fun `test extends type`() =
        assertCompletion("extends No<caret>", "Node")

    fun `test function type`() =
        assertCompletion("func get_name() -> <caret>", "String")

    fun `test function argument type`() =
        assertCompletion("func draw_quad(geometry: <caret>):", "ImmediateGeometry")

    fun `test language level function`() =
        assertCompletion("si<caret>", "sin")

    fun `test constant field`() =
        assertCompletion("AnimatedTexture.MAX_<caret>", "MAX_FRAMES")

    fun `test method`() =
        assertCompletion("sprite.is_<caret>()", "is_pixel_opaque")

    fun `test field setter`() =
        assertCompletion("compressor.set_back<caret>()", "set_background")

    fun `test field getter`() =
        assertCompletion("compressor.get_back<caret>()", "get_background")

    private fun assertCompletion(code: String, expectedLookup: String) {
        myFixture.configureByText(ScriptFileType, code)
        myFixture.completeBasic()
        myFixture.checkLookup(expectedLookup)
    }

    private fun CodeInsightTestFixture.checkLookup(expectedLookup: String) =
        assertTrue(lookupElementStrings!!.contains(expectedLookup))

}