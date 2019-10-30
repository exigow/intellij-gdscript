package gdscript.highlight

import com.intellij.lang.annotation.HighlightSeverity
import gdscript.BaseTest
import uitlities.openCode

class ScriptErrorHighlightingTest : BaseTest() {

    fun `test super method invocation`() =
        assertNoErrors("""
            func _change_state(state_name):
                ._change_state(state_name)
        """)

    fun `test semicolon`() =
        assertNoErrors("var x = 1; y = 2;; z = 3;;;")

    fun `test operator`() {
        assertNoErrors("x - y")
        assertNoErrors("x + y")
        assertNoErrors("x * y")
        assertNoErrors("x / y")
        assertNoErrors("x % y")
        assertNoErrors("x << y")
        assertNoErrors("x >> y")
        assertNoErrors("x ^ y")
        assertNoErrors("x | y")
        assertNoErrors("x && y")
        assertNoErrors("x || y")
    }

    fun `test operator assign`() {
        assertNoErrors("x = y")
        assertNoErrors("x := y")
        assertNoErrors("x += y")
        assertNoErrors("x -= y")
        assertNoErrors("x *= y")
        assertNoErrors("x /= y")
        assertNoErrors("x %= y")
        assertNoErrors("x &= y")
        assertNoErrors("x |= y")
    }

    fun `test operator negate`() {
        assertNoErrors("x = !y")
        assertNoErrors("x = ~y")
        assertNoErrors("x = -y")
    }

    fun `test operator keyword`() {
        assertNoErrors("x and y")
        assertNoErrors("x or y")
        assertNoErrors("x in y")
        assertNoErrors("x as y")
        assertNoErrors("x = not y")
    }

    fun `test continue`() =
        assertNoErrors("continue")

    fun `test break`() =
        assertNoErrors("break")

    fun `test if-elif-else statements`() =
        assertNoErrors("""
            if condition:
                print()
            elif condition:
                print()
            else:
                print()
        """)

    fun `test match constant pattern`() =
        assertNoErrors("""
            match x:
                1:
                    print("We are number one!")
                2:
                    print("Two are better than one!")
                "test":
                    print("Oh snap! It's a string!")
        """)

    fun `test match variable pattern`() =
        assertNoErrors("""
            match typeof(x):
                TYPE_REAL:
                    print("float")
                TYPE_STRING:
                    print("text")
                TYPE_ARRAY:
                    print("array")
        """)

    fun `test match wildcard pattern`() =
        assertNoErrors("""
            match x:
                1:
                    print("It's one!")
                2:
                    print("It's one times two!")
                _:
                    print("It's not 1 or 2. I don't care tbh.")
        """)

    fun `test constructor multiline`() =
        assertNoErrors("""
            x = Vector2(
                1,
                2
            )
        """)

    fun `test array multiline`() =
        assertNoErrors("""
            x = [
                1,
                2
            ]
        """)

    fun `test if-short with statement on the same line`() =
        assertNoErrors("y += 3 if y < 10 else -1")

    fun `test ternary-if with variable definition statement`() =
        assertNoErrors("var x = value if expression else value")

    fun `test return`() {
        assertNoErrors("return x")
        assertNoErrors("return")
    }

    fun `test ternary-if with assign and add statement`() =
        assertNoErrors("y += 3 if y < 10 else -1")

    fun `test allow newlines before first statement`() =
        assertNoErrors("\n\nclass_name Test")

    fun `test const`() =
        assertNoErrors("const MAX_HP = 100")

    fun `test const typed`() =
        assertNoErrors("const MAX_HP: int = 100")

    fun `test const with member expression as value`() =
        assertNoErrors("const POSITION = Vector2(20, 30).x")

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
        assertNoErrors("export(float, -10, 20, 0.2) var k")

    fun `test number base 10 integer`() =
        assertNoErrors("number = 45")

    fun `test number base 16 (hexadecimal) integer`() =
        assertNoErrors("hexadecimal = 0x8F51")

    fun `test number base 2 (binary) integer`() =
        assertNoErrors("binary = 0b101010")

    fun `test number floating-point`() =
        assertNoErrors("floating = 3.14")

    fun `test number floating-point scientific notation`() =
        assertNoErrors("scientific = 58.1e-10")

    fun `test number floating-point scientific alternative notation`() =
        assertNoErrors("scientific = 1e10")

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
        assertNoErrors("static func add(a, b):")

    fun `test function void`() =
        assertNoErrors("func some() -> void:")

    fun `test function puppet`() =
        assertNoErrors("puppet func do_explosion():")

    fun `test function master`() =
        assertNoErrors("master func exploded(by_who):")

    fun `test function sync`() =
        assertNoErrors("sync func update_score(add_to_left):")

    fun `test function default arguments`() {
        assertNoErrors("""func _closed(was_clean = false):""")
        assertNoErrors("""func _disconnected(id, was_clean = false):""")
        assertNoErrors("""func _connected(proto = ""):""")
    }

    fun `test negated condition`() =
        assertNoErrors("if !list.empty():")

    fun `test tool`() =
        assertNoErrors("tool")

    fun `test self`() =
        assertNoErrors("self")

    fun `test null`() =
        assertNoErrors("null")

    fun `test variable null`() =
        assertNoErrors("var entity = null")

    fun `test pass`() =
        assertNoErrors("pass")

    fun `test literal value true`() =
        assertNoErrors("condition = true")

    fun `test literal value false`() =
        assertNoErrors("condition = false")

    fun `test node path`() =
        assertNoErrors("node = \$C/Gamma/One")

    fun `test node path with digit`() =
        assertNoErrors("node = \$CollisionShape2D")

    fun `test node path string`() =
        assertNoErrors("rect_position = \$\"../BodyPivot\".position")

    fun `test signal`() =
        assertNoErrors("signal health_depleted")

    fun `test signal arguments`() =
        assertNoErrors("signal candidate_received(id, mid, index, sdp)")

    fun `test signal arguments empty`() =
        assertNoErrors("signal disconnected()")

    fun `test string double quotation mark`() =
        assertNoErrors("""text = "Hello!"""")

    fun `test string apostrophe`() =
        assertNoErrors("text = 'Hello!'")

    fun `test string multiline`() =
        assertNoErrors("text = \"\"\"Hello!\"\"\"")

    fun `test comment`() =
        assertNoErrors("# comment")

    fun `test comment after statement`() =
        assertNoErrors("var x = 1 # initialize")

    fun `test comment multiline`() =
        assertNoErrors("\"\"\"this is comment\"\"\"")

    fun `test negate`() =
        assertNoErrors("negated = -value")

    fun `test minus with no whitespace`() =
        assertNoErrors("""x = y -1""")

    fun `test inferred type operator with variable`() =
        assertNoErrors("var x := y")

    fun `test subscribe array`() =
        assertNoErrors("items[7] = 0")

    fun `test subscribe 2d array`() =
        assertNoErrors("""json_dict["albedo_color"]["r"] = albedo_color.r""")

    fun `test subscribe dictionary`() =
        assertNoErrors("""dict["Hi!"] = 0""")

    fun `test var`() =
        assertNoErrors("var hp")

    fun `test var puppet`() =
        assertNoErrors("puppet var x")

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

    fun `test var inferred type`() =
        assertNoErrors("var my_node := Sprite.new()")

    fun `test "class" with "extends"`() =
        assertNoErrors("class Lobby extends Reference:")

    fun `test "class"`() =
        assertNoErrors("class Coin:")

    fun `test extends class`() =
        assertNoErrors("extends SomeClass")

    fun `test extends resource class`() =
        assertNoErrors("""extends "Some.gd"""")

    fun `test extends resource inner class`() =
        assertNoErrors("""extends "Some.gd".SomeInnerClass""")

    fun `test extends resource inner-inner class`() =
        assertNoErrors("""extends "Some.gd".First.Second""")

    fun `test "is" operator with pre-loaded class type`() =
        assertNoErrors("""body is preload("res://player.gd"):""")

    fun `test error on two statements in one line (sanity check)`() {
        environment.openCode("var x var")
        val errors = environment.doHighlighting()
        assertTrue(errors[0].severity == HighlightSeverity.ERROR)
    }

    private fun assertNoErrors(code: String) {
        environment.openCode(code)
        environment.checkHighlighting()
    }

}