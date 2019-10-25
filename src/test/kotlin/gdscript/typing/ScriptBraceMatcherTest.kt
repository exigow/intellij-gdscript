package gdscript.typing

import gdscript.BaseTest
import uitlities.openCode

class ScriptBraceMatcherTest : BaseTest() {

    fun `test curly braces`() {
        environment.openCode("x = <caret>")
        environment.type('{')
        environment.checkResult("x = {<caret>}")
    }

    fun `test square braces`() {
        environment.openCode("x = <caret>")
        environment.type('[')
        environment.checkResult("x = [<caret>]"
        )
    }

    fun `test round braces`() {
        environment.openCode("x = <caret>")
        environment.type('(')
        environment.checkResult("x = (<caret>)")
    }

}