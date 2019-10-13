package script.typing

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import script.ScriptFileType

class QuoteHandlerTest : BasePlatformTestCase() {

    fun `test add double-quotes on new string and move caret inside`() {
        myFixture.configureByText(ScriptFileType, "x = <caret>")
        myFixture.type('"')
        myFixture.checkResult("x = \"<caret>\"")
    }

    fun `test remove double-quotes on BACKSPACE`() {
        myFixture.configureByText(ScriptFileType, "x = \"<caret>\"")
        myFixture.type('\b') // backslash
        myFixture.checkResult("x = <caret>")
    }

}