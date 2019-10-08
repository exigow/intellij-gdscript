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

    fun `test enum`() =
        assertNoErrors("enum {RED, GREEN, BLUE}")

    fun `test enum multiline`() =
        assertNoErrors("""
            enum {
                RED, 
                GREEN, 
                BLUE
            }
        """)

    fun `test enum custom values`() =
        assertNoErrors("enum {RED = 1, GREEN = 2, BLUE = 3}")

    fun `test enum named`() =
        assertNoErrors("enum Color {RED, GREEN, BLUE}")

    fun `test export`() =
        assertNoErrors("export var number")

    fun `test export FILE`() =
        assertNoErrors("""export(String, FILE, "*.txt") var f""")

    fun `test export number`() =
        assertNoErrors("""export(float, -10, 20, 0.2) var k""")

    fun `test export strings`() =
        assertNoErrors("""export(int, "Warrior", "Magician", "Thief") var character_class""")

    fun `test export 2D array`() =
        assertNoErrors("""export(Array, Array, float) var two_dimensional = [[1.0, 2.0], [3.0, 4.0]]""")

    fun `test function`() =
        assertNoErrors("func hit():")

    fun `test function argument`() =
        assertNoErrors("func hit(damage):")

    fun `test function argument type`() =
        assertNoErrors("func hit(damage: int):")

    fun `test function return type`() =
        assertNoErrors("func hit() -> float:")

    fun `test function static`() =
        assertNoErrors("static func max(a, b):")

    fun `test literal value self`() =
        assertNoErrors("self")

    fun `test literal value true`() =
        assertNoErrors("condition = true")

    fun `test literal value false`() =
        assertNoErrors("condition = false")

    fun `test node path`() =
        assertNoErrors("node = \$C/Gamma/One")

    fun `test signal`() =
        assertNoErrors("signal health_depleted")

    fun `test multiline string`() =
        assertNoErrors("message = \"\"\"Hello!\"\"\"")

    fun `test multiline string comment-like`() =
        assertNoErrors("\"\"\"this is comment\"\"\"")

    fun `test negate`() =
        assertNoErrors("negated = -value")

    fun `test subscribe array`() =
        assertNoErrors("items[7] = 0")

    fun `test subscribe dictionary`() =
        assertNoErrors("""dict["Hi!"] = 0""")

    fun `test var`() =
        assertNoErrors("var hp")

    fun `test var assignment`() =
        assertNoErrors("var hp = 73")

    fun `test var setget`() =
        assertNoErrors("var hp setget set_hp, get_hp")

    fun `test var setget only getter`() =
        assertNoErrors("var hp setget ,get_hp")

    fun `test var type`() =
        assertNoErrors("var hp: int")

    fun `test var type assignment`() =
        assertNoErrors("var hp: int = 73")

    private fun assertNoErrors(code: String) {
        myFixture.configureByText(ScriptFileType, code.trimIndent())
        myFixture.checkHighlighting()
    }

}