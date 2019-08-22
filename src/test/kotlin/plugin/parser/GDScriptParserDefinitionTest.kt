package plugin.parser

import com.intellij.testFramework.ParsingTestCase
import org.antlr.intellij.adaptor.xpath.XPath
import org.junit.Assert
import plugin.GDScript

class GDScriptParserDefinitionTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test var`() = assertXPathMatches(
        "var item")

    fun `test var assign`() = assertXPathMatches(
        "var health = 100")

    fun `test var export`() = assertXPathMatches(
        "export(Texture) var character_face")

    fun `test var export steps`() = assertXPathMatches(
        "export(float, -10, 20, 0.2) var k")

    fun `test var export file`() = assertXPathMatches(
        "export(String, FILE, GLOBAL, \"*.png\") var tool_image")

    fun `test var onready`() = assertXPathMatches(
        "onready var my_label = get_node")

    fun `test var setget`() = assertXPathMatches(
        "var health = 100 setget set_health, get_health")

    fun `test var setget only getter`() = assertXPathMatches(
        "var health = 100 setget ,get_health")

    fun `test var setget only setter`() = assertXPathMatches(
        "var health = 100 setget set_health")

    fun `test func`() = assertXPathMatches(
        "func init():")

    fun `test func typed`() = assertXPathMatches(
        "func size() -> Vector2:")

    fun `test func static`() = assertXPathMatches(
        "static func setup():")

    fun `test func arguments`() = assertXPathMatches(
        "func add(a, b):")

    fun `test array`() = assertXPathMatches(
        "var array = [1, 2, 3]")

    fun `test array empty`() = assertXPathMatches(
        "var empty = []")

    fun `test array subscription`() = assertXPathMatches(
        "array[1] = new_value")

    fun `test array subscription negative index`() = assertXPathMatches(
        "array[-3] = new_value")

    fun `test comment`() = assertXPathMatches(
        "# this is comment")

    fun `test comment after statement`() = assertXPathMatches(
        "var hp # Health points")

    fun `test comment ignored keywords`() = assertXPathMatches(
        "# what if class var dict = {}")

    fun `test comment ignored inner comment`() = assertXPathMatches(
        "# comment # just hash char")

    fun `test dictionary `() = assertXPathMatches(
        "var prices = {SWORD: 32, AXE: 24, POTION: 4}")

    fun `test dictionary empty`() = assertXPathMatches(
        "var empty = {}")

    fun `test dictionary multiline`() = assertXPathMatches("""
        val shades = {
            "white": 255,
            "gray": 128,
            "black": 0,
        }""")

    fun `test enum unnamed`() = assertXPathMatches(
        "enum { ENEMY, ALLY }")

    fun `test enum named`() = assertXPathMatches(
        "enum Color { RED, GREEN, BLUE }")

    fun `test enum multiline`() = assertXPathMatches("""
        enum Color {
            RED, 
            GREEN,
            BLUE 
        }""")

    fun `test class`() = assertXPathMatches(
        "class Node:")

    fun `test class name`() = assertXPathMatches(
        "class_name Hero")

    fun `test class name with icon`() = assertXPathMatches(
        "class_name Item, \"res://interface/icons/item.png\"")

    fun `test extends classname`() = assertXPathMatches(
        "extends BaseClass")

    fun `test extends path `() = assertXPathMatches(
        "extends res://path/to/character.gd")

    private fun assertXPathMatches(code: String, xpath: String = "/file") {
        myFile = createPsiFile("a", code.trimIndent())
        ensureParsed(myFile)
        val tree = ASTNodePrinter.build(myFile.node)
        val nodes = XPath.findAll(GDScript, myFile, xpath)
        if (nodes.isEmpty())
            Assert.fail("Unsatisfied selector '$xpath'\nCode:\n${myFile.text}\nTree:\n$tree")
        if (tree.contains("extraneous"))
            Assert.fail("Error: \n$tree")
        print(tree)
    }

}
