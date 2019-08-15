package plugin.parser

import com.intellij.testFramework.ParsingTestCase
import org.antlr.intellij.adaptor.xpath.XPath
import org.junit.Assert
import plugin.GDScript

class GDScriptParserDefinitionTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test simple`() {
        val code = """
            extends BaseClass
            extends Vector2D
            extends "base.gd"
            export(Texture) var character_face
            export(int, "Warrior", "Magician", "Thief") var character_class
            export(float, -10.0, 20.0, 0.2) var k_parameter
            var is_armed: bool = true
            var color: String = "blue"
            const MAX_AGE: int = 100
            export var damage: float = 74.9
            """
        assertXPathMatches(code, "/file")
    }

    fun `test complex`() {
        val code = """
            func is_empty():
                if angry:
                    return false
                if dead:
                    var range: float = Vector2
                    return false
                return true

            func attack(enemy, damage: int, vector: Vector2):
                pass
            """
        assertXPathMatches(code, "/file")
    }

    fun `test comment`() {
        val code = """
            # comment"
            return 1.23 # comment
            return true # comment # ignored comment
            """
        assertXPathMatches(code, "/file")
    }

    private fun assertXPathMatches(code: String, xpath: String) {
        myFile = createPsiFile("a", code.trimIndent())
        ensureParsed(myFile)
        val tree = ASTNodePrinter.build(myFile.node)
        val nodes = XPath.findAll(GDScript, myFile, xpath)
        if (nodes.isEmpty())
            Assert.fail("Unsatisfied selector '$xpath'\nCode:\n${myFile.text}\nTree:\n$tree")
        print(tree)
    }

}
