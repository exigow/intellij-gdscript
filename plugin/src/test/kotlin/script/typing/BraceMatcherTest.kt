package script.typing

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import script.ScriptFileType

class BraceMatcherTest : BasePlatformTestCase() {

    fun `test curly braces`() {
        myFixture.configureByText(ScriptFileType, "x = <caret>")
        myFixture.type('{')
        myFixture.checkResult("x = {<caret>}")
    }

    fun `test square braces`() {
        myFixture.configureByText(ScriptFileType, "x = <caret>")
        myFixture.type('[')
        myFixture.checkResult("x = [<caret>]"
        )
    }

    fun `test round braces`() {
        myFixture.configureByText(ScriptFileType, "x = <caret>")
        myFixture.type('(')
        myFixture.checkResult("x = (<caret>)")
    }

}