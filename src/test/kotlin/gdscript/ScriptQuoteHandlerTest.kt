package gdscript

import BaseTest
import utils.openScript

class ScriptQuoteHandlerTest : BaseTest() {

    fun `test add closing double quote`() {
        environment.openScript("x = <caret>")
        environment.type('"')
        environment.checkResult("x = \"<caret>\"")
    }

    fun `test remove closing double quote`() {
        environment.openScript("x = \"<caret>\"")
        environment.type('\b')
        environment.checkResult("x = <caret>")
    }

    fun `test overwrite closing double quote`() {
        environment.openScript("x = \"<caret>\"")
        environment.type('\"')
        environment.checkResult("x = \"\"<caret>")
    }

    fun `test add closing single quote`() {
        environment.openScript("x = <caret>")
        environment.type('\'')
        environment.checkResult("x = \'<caret>\'")
    }

    fun `test remove closing single quote`() {
        environment.openScript("x = \'<caret>\'")
        environment.type('\b')
        environment.checkResult("x = <caret>")
    }

    fun `test overwrite closing single quote`() {
        environment.openScript("x = \'<caret>\'")
        environment.type('\'')
        environment.checkResult("x = \'\'<caret>")
    }

}