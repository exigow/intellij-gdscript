package gdscript.typing

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.file.ScriptType

class ScriptQuoteHandlerTest : BasePlatformTestCase() {

    fun `test add double-quotes on new string and move caret inside`() {
        myFixture.configureByText(ScriptType, "x = <caret>")
        myFixture.type('"')
        myFixture.checkResult("x = \"<caret>\"")
    }

    fun `test remove double-quotes on BACKSPACE`() {
        myFixture.configureByText(ScriptType, "x = \"<caret>\"")
        myFixture.type('\b') // backslash
        myFixture.checkResult("x = <caret>")
    }

}