package script

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class ScriptTestCase : BasePlatformTestCase() {

    fun `test var`() =
        assertValid("var hp = 73")

    fun `test const`() =
        assertValid("const MAX_HP = 100")

    fun `test local variable`() =
        assertValid("position.x = 1")

    fun `test function declaration`() =
        assertValid("func bake():")

    private fun assertValid(code: String) {
        myFixture.configureByText(ScriptFileType, code)
        myFixture.checkHighlighting()
    }

}