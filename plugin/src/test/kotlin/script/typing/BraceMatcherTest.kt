package script.typing

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import script.ScriptFileType

class BraceMatcherTest : BasePlatformTestCase() {

    fun `test curly braces auto completion`() {
        myFixture.configureByText(ScriptFileType, "var dict = <caret>")
        myFixture.type('{')
        myFixture.checkResult("var dict = {<caret>}")
    }

}