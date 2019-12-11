package gdscript.lang.typing

import gdscript.BaseTest
import uitlities.openScript

class ScriptBraceMatcherTest : BaseTest() {

    fun `test curly braces`() {
        environment.openScript("x = <caret>")
        environment.type('{')
        environment.checkResult("x = {<caret>}")
    }

    fun `test square braces`() {
        environment.openScript("x = <caret>")
        environment.type('[')
        environment.checkResult("x = [<caret>]")
    }

    fun `test round braces`() {
        environment.openScript("x = <caret>")
        environment.type('(')
        environment.checkResult("x = (<caret>)")
    }

}