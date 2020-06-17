package gdscript

import BaseTest
import utils.openScript

class ScriptBraceMatcherTest : BaseTest() {

    fun `test add closing curly brace`() {
        environment.openScript("x = <caret>")
        environment.type('{')
        environment.checkResult("x = {<caret>}")
    }

    fun `test remove both curly braces`() {
        environment.openScript("x = {<caret>}")
        environment.type('\b')
        environment.checkResult("x = <caret>")
    }

    fun `test add closing square brace`() {
        environment.openScript("x = <caret>")
        environment.type('[')
        environment.checkResult("x = [<caret>]")
    }

    fun `test remove both square braces`() {
        environment.openScript("x = [<caret>]")
        environment.type('\b')
        environment.checkResult("x = <caret>")
    }

    fun `test add closing round brace`() {
        environment.openScript("x = <caret>")
        environment.type('(')
        environment.checkResult("x = (<caret>)")
    }

    fun `test remove both round braces`() {
        environment.openScript("x = (<caret>)")
        environment.type('\b')
        environment.checkResult("x = <caret>")
    }

}