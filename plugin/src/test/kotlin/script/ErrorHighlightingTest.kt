package script

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class ErrorHighlightingTest : BasePlatformTestCase() {

    fun `test var`() =
        assertNoErrors("var hp")

    fun `test var with assignment`() =
        assertNoErrors("var hp = 73")

    fun `test var typed`() =
        assertNoErrors("var hp: int = 73")

    fun `test var setget`() =
        assertNoErrors("var hp setget set_hp, get_hp")

    fun `test var setget with getter only`() =
        assertNoErrors("var hp setget ,get_hp")

    fun `test export`() =
        assertNoErrors("export var number = 5")

    fun `test export int`() =
        assertNoErrors("export(int) var number")

    fun `test export strings`() =
        assertNoErrors("""export(int, "Warrior", "Magician", "Thief") var character_class""")

    fun `test export FILE`() =
        assertNoErrors("""export(String, FILE, "*.txt") var f""")

    fun `test export numbers`() =
        assertNoErrors("""export(float, -10, 20, 0.2) var k""")

    fun `test export 2D array`() =
        assertNoErrors("""export(Array, Array, float) var two_dimensional = [[1.0, 2.0], [3.0, 4.0]]""")

    fun `test signal`() =
        assertNoErrors("""signal health_depleted""")

    fun `test multiline string comment-like`() =
        assertNoErrors("\"\"\"Inventory.gd\"\"\"")

    fun `test increment`() =
        assertNoErrors("hp += 10")

    fun `test negate number`() =
        assertNoErrors("negated = -1")

    fun `test negate`() =
        assertNoErrors("negated = -value")

    fun `test get_node`() =
        assertNoErrors("""get_node("C/Gamma/One")""")

    fun `test self keyword`() =
        assertNoErrors("self.get_position().x = 1")

    fun `test get_node $ sugar`() =
        assertNoErrors("var node = \$C/Gamma/One")

    fun `test get_node local variable assignment`() =
        assertNoErrors("\$C/Gamma/One.text = \"New Text\"")

    fun `test dictionary assignment entries`() =
        assertNoErrors("""
            const CORNER = {
                W = 0,
                NW = 1,
                NE = 2,
                E = 3,
                SE = 4,
                SW = 5
            }
        """)

    fun `test constant dictionary with string keys`() =
        assertNoErrors("""
            const HEROES = {
                "Warrior": 0,
                "Magician": 1,
                "Thief": 2
            }
        """)

    fun `test assigned dictionary with number keys`() =
        assertNoErrors("""
            dict = {
                100: "INFO",
                400: "WARN",
            }
        """)

    fun `test named enum`() =
        assertNoErrors("""
            enum Color {
                RED, GREEN, BLUE
            }
        """)

    fun `test enum`() =
        assertNoErrors("enum {THING_1, THING_2, ANOTHER_THING = -1}")

    fun `test single line dictionary`() =
        assertNoErrors("""var dict = {4: 5, "A key": "A value", 28: [1, 2, 3]}""")

    fun `test const`() =
        assertNoErrors("const MAX_HP = 100")

    fun `test array subscription`() =
        assertNoErrors("""table[4] = "hello"""")

    fun `test dictionary subscription`() =
        assertNoErrors("""dict["Hi!"] = 0""")

    fun `test local variable assignment`() =
        assertNoErrors("position.x = 1")

    fun `test typed function with non-typed argument`() =
        assertNoErrors("""
            func hit(damage) -> bool:
                health_points -= damage
                return health_points <= 0
        """)

    fun `test function with pass statement`() =
        assertNoErrors("""
            func _on_area_entered(area : CollisionObject2D) -> void:
                pass
        """)


    fun `test static typed function with typed arguments`() =
        assertNoErrors("static func max(a: float, b: float) -> float:")

    private fun assertNoErrors(code: String) {
        myFixture.configureByText(ScriptFileType, code.trimIndent())
        myFixture.checkHighlighting()
    }

}