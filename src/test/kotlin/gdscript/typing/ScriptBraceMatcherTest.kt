package gdscript.typing

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.file.ScriptType

class ScriptBraceMatcherTest : BasePlatformTestCase() {

    fun `test curly braces`() {
        myFixture.configureByText(ScriptType, "x = <caret>")
        myFixture.type('{')
        myFixture.checkResult("x = {<caret>}")
    }

    fun `test square braces`() {
        myFixture.configureByText(ScriptType, "x = <caret>")
        myFixture.type('[')
        myFixture.checkResult("x = [<caret>]"
        )
    }

    fun `test round braces`() {
        myFixture.configureByText(ScriptType, "x = <caret>")
        myFixture.type('(')
        myFixture.checkResult("x = (<caret>)")
    }

}