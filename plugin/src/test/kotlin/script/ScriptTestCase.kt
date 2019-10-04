package script

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class ScriptTestCase : BasePlatformTestCase() {

    fun `test var`() =
        assertValid("var hp = 73")

    fun `test assign`() =
        assertValid("hp -= 10")

    fun `test negated number`() =
        assertValid("negated = -1")

    fun `test negate reference`() =
        assertValid("negated = -value")

    fun `test get_node`() =
        assertValid("""get_node("C/Gamma/One")""")

    fun `test get_node $ sugar`() =
        assertValid("var node = \$C/Gamma/One")

    fun `test get_node local variable assignment`() =
        assertValid("\$C/Gamma/One.text = \"New Text\"")

    fun `test dictionary assignment entries`() =
        assertValid("""
        const CORNER = {
            W = 0,
            NW = 1,
            NE = 2,
            E = 3,
            SE = 4,
            SW = 5
        }
        """)

    fun `test dictionary colon entries`() =
        assertValid("""
        const HEROES = {
            "Warrior": 0,
            "Magician": 1,
            "Thief": 2
        }
        """)

    fun `test dictionary number`() =
        assertValid("""
        d = {
            22: "value",
        }
        """)

    fun `test dictionary single line`() =
        assertValid("""var d = {4: 5, "A key": "A value", 28: [1, 2, 3]}""")

    fun `test const`() =
        assertValid("const MAX_HP = 100")

    fun `test array subscription`() =
        assertValid("""d[4] = "hello"""")

    fun `test dictionary subscription`() =
        assertValid("""d["Hi!"] = 0""")

    fun `test local variable`() =
        assertValid("position.x = 1")

    fun `test function declaration`() =
        assertValid("static func create() -> Node:")

    private fun assertValid(code: String) {
        myFixture.configureByText(ScriptFileType, code.trimIndent())
        myFixture.checkHighlighting()
    }

}