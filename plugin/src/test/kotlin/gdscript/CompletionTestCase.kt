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

    fun `test built-in Sprite method`() =
        assertContainsLookup("var opaque = Sprite.is_<caret>", "is_pixel_opaque")

    private fun assertContainsLookup(code: String, expectedLookup: String) {
        myFixture.configureByText(GdFileType, code)
        myFixture.complete(CompletionType.BASIC)
        assertTrue(myFixture.lookupElementStrings!!.contains(expectedLookup))
    }

}