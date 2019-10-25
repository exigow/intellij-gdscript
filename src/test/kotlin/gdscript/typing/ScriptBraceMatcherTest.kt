package gdscript.typing

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.file.ScriptType
import uitlities.addCode

class ScriptBraceMatcherTest : BasePlatformTestCase() {

    fun `test curly braces`() {
        myFixture.addCode("x = <caret>")
        myFixture.type('{')
        myFixture.checkResult("x = {<caret>}")
    }

    fun `test square braces`() {
        myFixture.addCode("x = <caret>")
        myFixture.type('[')
        myFixture.checkResult("x = [<caret>]"
        )
    }

    fun `test round braces`() {
        myFixture.addCode("x = <caret>")
        myFixture.type('(')
        myFixture.checkResult("x = (<caret>)")
    }

}