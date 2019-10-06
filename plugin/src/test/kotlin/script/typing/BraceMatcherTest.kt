package script.typing

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import script.ScriptFileType

class BraceMatcherTest : BasePlatformTestCase() {

    fun `test curly braces auto completion`() =
        assertTyping(given = "var dict = <caret>", typing = '{', expected = "var dict = {<caret>}")

    fun `test square brackets auto completion`() =
        assertTyping(given = "var array = <caret>", typing = '[', expected = "var array = [<caret>]")

    private fun assertTyping(given: String, typing: Char, expected: String) {
        myFixture.configureByText(ScriptFileType, given)
        myFixture.type(typing)
        myFixture.checkResult(expected)
    }

}