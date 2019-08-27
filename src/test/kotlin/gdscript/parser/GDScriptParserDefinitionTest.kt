package gdscript.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Assert

class GDScriptParserDefinitionTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test literal string`() = assertValid(
        "name = \"Skeleton\"")

    fun `test literal get node shorthand`() = assertValid(
        "node = \$NodePath")

    fun `test literal number`() = assertValid(
        "chance = 0.0917")

    fun `test literal hex`() = assertValid(
        "hex = 0x8F51")

    fun `test assign`() = assertValid(
        "a = b")

    fun `test operator arithmetic`() = assertValid(
        "t = x * y / z + w - h")

    fun `test operator brackets`() = assertValid(
        "i = (j + (i) + (j + i))")

    fun `test operator attribute reference`() = assertValid(
        "size = array.length")

    fun `test operator instance type check`() = assertValid(
        "is_circle = shape is Circle")

    fun `test operator cast`() = assertValid(
        "my_int = \"123\" as int")

    fun `test operator method`() = assertValid(
        "max = list.size()")

    fun `test operator boolean keyword`() = assertValid(
        "yes = y not n and y or n")

    fun `test operator boolean symbol`() = assertValid(
        "yes = y ! n && y || n")

    fun `test operator bitwise`() = assertValid(
        "b = e ~ f & g ^ h | i")

    fun `test operator comparision`() = assertValid(
        "q = a < b > c == d != e >= f <= g")

    fun `test operator content`() = assertValid(
        "has_potion = potion in items")

    fun `test array empty`() = assertValid(
        "empty = []")

    fun `test array with values`() = assertValid(
        "array = [1, 2, 3]")

    fun `test array subscription`() = assertValid(
        "array[0] = 1")

    fun `test array subscription with negated index`() = assertValid(
        "array[-1] = 1")

    fun `test var`() = assertValid(
        "var item")

    fun `test var assign`() = assertValid(
        "var health = 100")

    fun `test var typed`() = assertValid(
        "var position: Vector2")

    fun `test var export`() = assertValid(
        "export(Texture) var character_face")

    fun `test var export steps`() = assertValid(
        "export(float, -10, 20, 0.2) var k")

    fun `test var export file`() = assertValid(
        "export(String, FILE, GLOBAL, \"*.png\") var tool_image")

    fun `test var onready`() = assertValid(
        "onready var my_label = get_node")

    fun `test var setget`() = assertValid(
        "var health = 100 setget set_health, get_health")

    fun `test var setget only getter`() = assertValid(
        "var health = 100 setget ,get_health")

    fun `test var setget only setter`() = assertValid(
        "var health = 100 setget set_health")

    fun `test const`() = assertValid(
        "const MAX_SIZE = 30")

    fun `test const typed`() = assertValid(
        "const ALLY_COLOR: Color = green")

    fun `test func`() = assertValid(
        "func init():")

    fun `test func arguments`() = assertValid(
        "func add(a, b):")

    fun `test func typed result`() = assertValid(
        "func size() -> Vector2:")

    fun `test func static`() = assertValid(
        "static func setup():")

    fun `test func typed arguments`() = assertValid(
        "func get_damage(is_critical: bool):")

    fun `test for`() = assertValid(
        "for e in elements:")

    fun `test for with expression`() = assertValid(
        "for i in range(2, 10):")

    fun `test while`() = assertValid(
        "while true:")

    fun `test line comment`() = assertValid(
        "# this is comment")

    fun `test line comment after statement`() = assertValid(
        "var hp # Health points")

    fun `test line comment ignored keywords`() = assertValid(
        "# what if class var dict = {}")

    fun `test line comment ignored inner comment`() = assertValid(
        "# comment # just hash char")

    fun `test block comment`() = assertValid(
        "\"\"\" comment \"\"\"")

    fun `test block comment multiline`() = assertValid(
        "\"\"\"\ncomment\n\"\"\"")

    fun `test enum unnamed`() = assertValid(
        "enum { ENEMY, ALLY }")

    fun `test enum named`() = assertValid(
        "enum Color { RED, GREEN, BLUE }")

    fun `test class`() = assertValid(
        "class Node:")

    fun `test class name`() = assertValid(
        "class_name Hero")

    fun `test class name with icon`() = assertValid(
        "class_name Item, \"res://interface/icons/item.png\"")

    fun `test extends classname`() = assertValid(
        "extends BaseClass")

    private fun assertValid(code: String) {
        myFile = createPsiFile("a", code.trimIndent())
        ensureParsed(myFile)
        val tree = ASTNodePrinter.build(myFile.node)
        if (tree.contains("extraneous") || tree.contains("mismatched") || tree.contains("ERROR_ELEMENT"))
            Assert.fail("Error: \n$tree")
        print(tree)
    }

}
