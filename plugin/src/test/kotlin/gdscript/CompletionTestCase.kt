package gdscript

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class CompletionTestCase : BasePlatformTestCase() {

    fun `test variable keyword completion`() =
        assertContainsLookup("va<caret>", "var")

    fun `test variable type completion`() =
        assertContainsLookup("var position: Vec<caret>", "Vector2")

    fun `test function type completion`() =
        assertContainsLookup("func get_name() -> <caret>", "String")

    fun `test function argument type completion`() =
        assertContainsLookup("func draw_quad(geometry: <caret>):", "ImmediateGeometry")

    fun `test language level function completion`() =
        assertContainsLookup("si<caret>", "sin")

    fun `test constant field completion`() =
        assertContainsLookup("AnimatedTexture.MAX_<caret>", "MAX_FRAMES")

    fun `test method completion`() =
        assertContainsLookup("sprite.is_<caret>", "is_pixel_opaque")

    fun `test getter completion`() =
        assertContainsLookup("compressor.set_back<caret>", "set_background")

    private fun assertContainsLookup(code: String, expectedLookup: String) {
        myFixture.configureByText(GdFileType, code)
        myFixture.complete(CompletionType.BASIC)
        assertTrue(myFixture.lookupElementStrings!!.contains(expectedLookup))
    }

}