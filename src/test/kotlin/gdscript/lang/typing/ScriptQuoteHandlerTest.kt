package gdscript.lang.typing

import gdscript.BaseTest
import uitlities.openScript

class ScriptQuoteHandlerTest : BaseTest() {

    fun `test Double-Quote completion`() {
        environment.openScript("x = <caret>")
        environment.type('"')
        environment.checkResult("x = \"<caret>\"")
    }

    fun `test Apostrophe completion`() {
        environment.openScript("x = <caret>")
        environment.type('\'')
        environment.checkResult("x = \'<caret>\'")
    }

    fun `test remove Double-Quote on Backspace`() {
        environment.openScript("x = \"<caret>\"")
        environment.type(BACKSPACE)
        environment.checkResult("x = <caret>")
    }

    fun `test remove Apostrophe on Backspace`() {
        environment.openScript("x = \'<caret>\'")
        environment.type(BACKSPACE)
        environment.checkResult("x = <caret>")
    }

    companion object {
        const val BACKSPACE = '\b'
    }

}