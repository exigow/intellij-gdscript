package plugin.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Assert

class GDScriptParserDefinitionTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

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

    fun `test func typed`() = assertValid(
        "func size() -> Vector2:")

    fun `test func static`() = assertValid(
        "static func setup():")

    fun `test func arguments`() = assertValid(
        "func add(a, b):")

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
