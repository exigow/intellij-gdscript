package script

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class ScriptTestCase : BasePlatformTestCase() {

    fun `test var`() =
        assertValid("var hp")

    fun `test var with assignment`() =
        assertValid("var hp = 73")

    fun `test var typed`() =
        assertValid("var hp: int = 73")

    fun `test var setget`() =
        assertValid("var hp setget set_hp, get_hp")

    fun `test var setget with getter only`() =
        assertValid("var hp setget ,get_hp")

    fun `test export`() =
        assertValid("export var number = 5")

    fun `test export arguments`() =
        assertValid("export(int) var number")

    fun `test export multiple arguments`() =
        assertValid("""export(int, "Warrior", "Magician", "Thief") var character_class""")

    fun `test multiline string comment-like`() =
        assertValid("\"\"\"Inventory.gd\"\"\"")

    fun `test increment`() =
        assertValid("hp += 10")

    fun `test negate number`() =
        assertValid("negated = -1")

    fun `test negate`() =
        assertValid("negated = -value")

    fun `test get_node`() =
        assertValid("""get_node("C/Gamma/One")""")

    fun `test self keyword`() =
        assertValid("self.get_position().x = 1")

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

    fun `test constant dictionary with string keys`() =
        assertValid("""
            const HEROES = {
                "Warrior": 0,
                "Magician": 1,
                "Thief": 2
            }
        """)

    fun `test assigned dictionary with number keys`() =
        assertValid("""
            dict = {
                100: "INFO",
                400: "WARN",
            }
        """)

    fun `test named enum`() =
        assertValid("""
            enum Color {
                RED, GREEN, BLUE
            }
        """)

    fun `test enum`() =
        assertValid("enum { A, B, C }")

    fun `test single line dictionary`() =
        assertValid("""var dict = {4: 5, "A key": "A value", 28: [1, 2, 3]}""")

    fun `test const`() =
        assertValid("const MAX_HP = 100")

    fun `test array subscription`() =
        assertValid("""table[4] = "hello"""")

    fun `test dictionary subscription`() =
        assertValid("""dict["Hi!"] = 0""")

    fun `test local variable assignment`() =
        assertValid("position.x = 1")

    fun `test typed function with non-typed argument`() =
        assertValid("""
            func hit(damage) -> bool:
                health_points -= damage
                return health_points <= 0
        """)

    fun `test function with pass statement`() =
        assertValid("""
            func _on_area_entered(area : CollisionObject2D) -> void:
                pass
        """)


    fun `test static typed function with typed arguments`() =
        assertValid("static func max(a: float, b: float) -> float:")

    private fun assertValid(code: String) {
        myFixture.configureByText(ScriptFileType, code.trimIndent())
        myFixture.checkHighlighting()
    }

}