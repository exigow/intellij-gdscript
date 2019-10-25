package gdscript.typing

import gdscript.BaseTest
import uitlities.openCode

class ScriptQuoteHandlerTest : BaseTest() {

    fun `test add double-quotes on new string and move caret inside`() {
        environment.openCode("x = <caret>")
        environment.type('"')
        environment.checkResult("x = \"<caret>\"")
    }

    fun `test remove double-quotes on BACKSPACE`() {
        environment.openCode("x = \"<caret>\"")
        environment.type('\b') // backslash
        environment.checkResult("x = <caret>")
    }

}