package plugin.parser

import com.intellij.testFramework.ParsingTestCase
import org.antlr.intellij.adaptor.xpath.XPath
import org.junit.Assert
import plugin.GDScript

class GDScriptParserDefinitionTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test blocks`() {
        val code = """
            func add_items(item_type, amount):
                if item_type:
                    return null
                else:
                    return amount * 2
                break

            func _init() -> void:
                pass

            func create_vector() -> Vector2:
                return null
            """
        assertXPathMatches(code)
    }

    fun `test extends`() {
        val code = """
            extends BaseClass
            extends Vector2, "vector2.gd"
            extends "base.gd"
            """
        assertXPathMatches(code)
    }

    fun `test enum`() {
        val code = """
            enum {UNIT_ENEMY, UNIT_ALLY}
            enum Color {RED, GREEN = "message", UNKNOWN = -1}
            """
        assertXPathMatches(code)
    }

    fun `test var export`() {
        val code = """
            var declaration_only
            var declaration_and_initialisation = 1.0
            onready var x = Vector2(1, 2)
            export(int) var volume
            export(int, "Warrior", "Magician", "Thief") var character_class
            export(float, -10.0, PATH = "hello") var parameter = 0.72
            """
        assertXPathMatches(code)
    }

    fun `test var setget`() {
        val code = """
            # setter and getter
            var health = 100 setget set_health, get_health
            # only setter
            var health = 5 setget set_health
            # only getter (see: comma)
            var my_var = 5 setget ,get_health
            """
        assertXPathMatches(code)
    }

    fun `test array init`() {
        val code = """
            var array = ["Hello" + "World", Vector2, MAX_HEALTH]
            array[0] = "Godot"
            array[-1] = MIN_HEALTH
            array[1 + 2] = SomeValue
            """
        assertXPathMatches(code)
    }

    fun `test complex operator expression`() {
        val code = """
            var damage = level.current + get_weapon_attack(Axe) * skill[STR_INDEX] / 3.14
            var a = Vector2(2, 4)
            var m = sqrt(a.x * a.x + a.y * a.y)
            a.x /= m
            a.y /= m
            """
        assertXPathMatches(code)
    }

    fun `test comment`() {
        val code = """
            # comment
            return null # comment after statement
            """
        assertXPathMatches(code)
    }

    private fun assertXPathMatches(code: String, xpath: String = "/file") {
        myFile = createPsiFile("a", code.trimIndent())
        ensureParsed(myFile)
        val tree = ASTNodePrinter.build(myFile.node)
        val nodes = XPath.findAll(GDScript, myFile, xpath)
        if (nodes.isEmpty())
            Assert.fail("Unsatisfied selector '$xpath'\nCode:\n${myFile.text}\nTree:\n$tree")
        print(tree)
    }

}
