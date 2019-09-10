package gdscript

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class CompletionTestCase : BasePlatformTestCase() {

    fun `test var keyword`() =
        assertContainsLookup("va<caret>", "var")

    fun `test built-in Vector2 type`() =
        assertContainsLookup("var position: Vec<caret>", "Vector2")

    fun `test built-in language level sin() function`() =
        assertContainsLookup("si<caret>", "sin")

    fun `test built-in Color const`() =
        assertContainsLookup("var item_color = Color.blu<caret>", "blueviolet")

    fun `test built-in Camera2D anchor const`() =
        assertContainsLookup("camera.anchor_mode = Camera2D.ANCHOR_<caret>", "ANCHOR_MODE_FIXED_TOP_LEFT")

    fun `test built-in Sprite is_pixel_opaque method`() =
        assertContainsLookup("var opaque = Sprite.is_<caret>", "is_pixel_opaque")

    fun `test built-in Environment set_background setter`() =
        assertContainsLookup("compressor.set_back<caret>", "set_background")

    private fun assertContainsLookup(code: String, expectedLookup: String) {
        myFixture.configureByText(GdFileType, code)
        myFixture.complete(CompletionType.BASIC)
        assertTrue(myFixture.lookupElementStrings!!.contains(expectedLookup))
    }

}