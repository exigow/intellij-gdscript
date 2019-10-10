package script

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class ErrorHighlightingTest : BasePlatformTestCase() {

    fun `test const`() =
        assertNoErrors("const MAX_HP = 100")

    fun `test const typed`() =
        assertNoErrors("const MAX_HP: int = 100")

    fun `test dictionary`() =
        assertNoErrors("""var dict = {4: 5, "A key": "A value", 28: [1, 2, 3]}""")

    fun `test dictionary Lua style multiline`() =
        assertNoErrors("""
            dict = {
                test22 = "value",
                some_key = 2,
                other_key = [2, 3, 4],
                more_key = "Hello"
            }
        """)

    fun `test dictionary multiline`() =
        assertNoErrors("""
             dict = {
                "key": "value",
                123: 456
            }
        """)

    fun `test error on two statements in one line`() {
        myFixture.configureByText(ScriptFileType, "var x var")
        val high = myFixture.doHighlighting()
        assertTrue(high[0].description.contains("mismatched input 'var'"))
    }

    private fun assertNoErrors(code: String) {
        myFixture.configureByText(ScriptFileType, code.trimIndent() + "\n")
        myFixture.checkHighlighting()
    }

}